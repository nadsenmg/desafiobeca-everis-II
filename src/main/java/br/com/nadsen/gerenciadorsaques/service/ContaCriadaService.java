package br.com.nadsen.gerenciadorsaques.service;

import br.com.nadsen.gerenciadorsaques.model.LimiteConta;
import br.com.nadsen.gerenciadorsaques.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaCriadaService {

    private final ContaRepository contaRepository;

    public LimiteConta getContaCriada(Integer numConta){
        return contaRepository.getByNumConta(numConta);
    }
}
