package viagens.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import viagens.web.api.domain.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Long> {

}
