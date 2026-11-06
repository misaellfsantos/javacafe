package senai.com.br.javacafeteria.repository;

import senai.com.br.javacafeteria.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}