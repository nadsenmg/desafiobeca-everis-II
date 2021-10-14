package br.com.nadsen.gerenciadorsaques.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimiteSaquesResponse {

    private Integer numConta;
    private long saquesGratuitos;
}
