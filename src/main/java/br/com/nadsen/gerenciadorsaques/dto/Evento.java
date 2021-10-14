package br.com.nadsen.gerenciadorsaques.dto;

import br.com.nadsen.gerenciadorsaques.model.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    private Long id;
    private Integer numConta;
    private String tipoConta;
    private long qtdSaques;
    private TipoEvento tipoEvento;
    private Timestamp dataEvento;

}
