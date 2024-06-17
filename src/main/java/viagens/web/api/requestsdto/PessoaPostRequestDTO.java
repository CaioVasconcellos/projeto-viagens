package viagens.web.api.requestsdto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import viagens.web.api.requests.PessoaEnderecoPostRequestBody;
import viagens.web.api.requests.PessoaPostRequestBody;
import viagens.web.api.requests.PessoaTelefonePostRequestBody;

import java.util.List;

@Data
public class PessoaPostRequestDTO {
    private PessoaPostRequestBody pessoaPostRequestBody;
    private PessoaEnderecoPostRequestBody pessoaEnderecoPostRequestBody;
    private List<PessoaTelefonePostRequestBody> pessoaTelefonePostRequestBody;
}
