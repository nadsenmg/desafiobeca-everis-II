package br.com.nadsen.gerenciadorsaques.repository;

import br.com.nadsen.gerenciadorsaques.model.LimiteConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<LimiteConta, Long> {
    LimiteConta getByNumConta(Integer numConta);
}
