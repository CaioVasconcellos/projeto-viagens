package viagens.web.api.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import viagens.web.api.until.SEXO;

import java.time.LocalDate;

@Data
public class PessoaPostRequestBody {
    @Schema(description = "Nome do usuário", example = "João")
    private String nome;
    @Schema(description = "Email do usuário", example = "joão@teste.com")
    private String email;
    @Schema(description = "Sexo do usuário", example = "M ou F")
    private SEXO sexo;
    @Schema(description = "Data de nascimento do usuário", example = "2000-01-20")
    private LocalDate dataNascimento;
}
