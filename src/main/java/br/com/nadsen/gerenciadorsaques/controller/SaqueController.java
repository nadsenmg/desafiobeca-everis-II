package br.com.nadsen.gerenciadorsaques.controller;

import br.com.nadsen.gerenciadorsaques.dto.LimiteSaquesResponse;
import br.com.nadsen.gerenciadorsaques.model.LimiteConta;
import br.com.nadsen.gerenciadorsaques.service.ContaCriadaService;
import br.com.nadsen.gerenciadorsaques.service.SaqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SaqueController {

    private final SaqueService saqueService;

    @GetMapping("conta/{numConta}/qtdSaques")
    public LimiteSaquesResponse getTotalSaquesDisponiveis(@PathVariable Integer numConta) {
       long qtdSaquesDisponveis = saqueService.getTotalSaquesDisponiveis(numConta);
        return new LimiteSaquesResponse(numConta,qtdSaquesDisponveis);
    }

}
