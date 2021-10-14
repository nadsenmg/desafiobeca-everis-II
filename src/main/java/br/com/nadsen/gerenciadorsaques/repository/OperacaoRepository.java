package br.com.nadsen.gerenciadorsaques.repository;

import br.com.nadsen.gerenciadorsaques.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    Operacao findByNumConta(Integer numConta);

    @Query("select count(*) from #{#entityName} op where op.numConta= ?1 AND op.tipoEvento = 'SAQUE_EFETUADO' AND op.dataEvento between ?2 and ?3")
    long getTotalSaquesBetween (Integer numConta, Timestamp dataInicial, Timestamp dataFinal);
}
