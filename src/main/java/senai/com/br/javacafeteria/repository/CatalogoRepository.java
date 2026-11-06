
package senai.com.br.javacafeteria.repository;

import senai.com.br.javacafeteria.model.Catalogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository
        extends JpaRepository<Catalogo, Long> {

}
