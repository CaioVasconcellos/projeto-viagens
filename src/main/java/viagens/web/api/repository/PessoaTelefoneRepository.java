package viagens.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import viagens.web.api.domain.PessoaTelefone;

public interface PessoaTelefoneRepository extends JpaRepository<PessoaTelefone, Long> {

}
