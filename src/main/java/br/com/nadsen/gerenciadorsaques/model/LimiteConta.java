package br.com.nadsen.gerenciadorsaques.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LimiteConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numConta;

    @Enumerated (EnumType.STRING)
    private TipoConta tipoConta;

    private long qtdSaques;

    @Column(name = "data_criacao")
    private Timestamp dataEvento;

}
