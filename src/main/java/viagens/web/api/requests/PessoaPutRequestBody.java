package viagens.web.api.requests;

import lombok.Data;
import viagens.web.api.until.SEXO;
import java.time.LocalDate;

@Data
public class PessoaPutRequestBody {
    private Long id;
    private String nome;
    private String email;
    private SEXO sexo;
    private LocalDate dataNascimento;
}
