package viagens.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import viagens.web.api.domain.PessoaEndereco;
import viagens.web.api.until.UF;

import java.util.List;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {

}
