package viagens.web.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import viagens.web.api.domain.Pessoa;
import viagens.web.api.requestsdto.PessoaInfoDTO;
import viagens.web.api.until.UF;

import java.util.List;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByEmail(String email);

    @Query ("SELECT p FROM Pessoa p WHERE p.nome LIKE %:nome%")
    List<Pessoa> findByNome(@Param("nome") String nome);

    @Query("SELECT p FROM Pessoa p JOIN p.pessoaEndereco e WHERE e.uf = :uf")
    List<Pessoa> findByUF(@Param("uf") UF uf);

}
