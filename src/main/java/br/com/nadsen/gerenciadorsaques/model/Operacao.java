package br.com.nadsen.gerenciadorsaques.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Operacao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numConta;
    @Enumerated (EnumType.STRING)
    private TipoEvento tipoEvento;

    private Timestamp dataEvento;
}
