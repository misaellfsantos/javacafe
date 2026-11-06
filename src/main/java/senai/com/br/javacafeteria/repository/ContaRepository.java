package senai.com.br.javacafeteria.repository;

import senai.com.br.javacafeteria.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}