package viagens.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import viagens.web.api.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
