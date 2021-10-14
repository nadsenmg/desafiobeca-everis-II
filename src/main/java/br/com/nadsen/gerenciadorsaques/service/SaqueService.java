package br.com.nadsen.gerenciadorsaques.service;

import br.com.nadsen.gerenciadorsaques.dto.Evento;
import br.com.nadsen.gerenciadorsaques.model.*;
import br.com.nadsen.gerenciadorsaques.repository.ContaRepository;
import br.com.nadsen.gerenciadorsaques.repository.OperacaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaqueService {

    private final ContaRepository contaRepository;
    private final OperacaoRepository operacaoRepository;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    @KafkaListener(topics = "CONTROLE_SAQUES", groupId = "CONTROLE_SAQUES", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(String mensagem) {
        try {
            Evento evento = objectMapper.readValue(mensagem, Evento.class);
            if (evento.getTipoEvento() == TipoEvento.CONTA_CRIADA) {
                log.info("Mensagem de conta criada recebida com sucesso! ");
                LimiteConta limiteConta = modelMapper.map(evento, LimiteConta.class);
                limiteConta.setQtdSaques(limiteConta.getTipoConta().getQtdSaques());
                contaRepository.save(limiteConta);
            } else if (evento.getTipoEvento() == TipoEvento.SAQUE_EFETUADO) {
                log.info("Mensagem de saque efetuado recebida com sucesso! ");
                operacaoRepository.save(modelMapper.map(evento, Operacao.class));
            } else {
                log.info("Ignorando mensagem do kafka" + evento);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public long getTotalSaquesDisponiveis(Integer numConta) {
        log.info("GETTING LIMITE CONTA FOR NUMCONTA -> ", numConta);
        LimiteConta limiteConta = contaRepository.getByNumConta(numConta);
        long totalSaques = limiteConta.getQtdSaques();
        LocalDateTime atual = LocalDateTime.now();
        LocalDateTime dataInicial = LocalDateTime.of(atual.getYear(), atual.getMonth(), 1, 0, 0, 0);
        long qtdSaquesEfetuados = operacaoRepository.getTotalSaquesBetween(numConta, Timestamp.valueOf(dataInicial), Timestamp.valueOf(atual));
        return qtdSaquesEfetuados > totalSaques ? 0 : totalSaques-qtdSaquesEfetuados;
    }
}