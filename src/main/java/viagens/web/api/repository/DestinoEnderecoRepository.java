package viagens.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import viagens.web.api.domain.DestinoEndereco;

public interface DestinoEnderecoRepository extends JpaRepository<DestinoEndereco, Long> {

}
