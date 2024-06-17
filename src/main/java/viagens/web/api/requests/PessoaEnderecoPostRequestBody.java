package viagens.web.api.requests;

import lombok.Data;
import viagens.web.api.until.UF;

@Data
public class PessoaEnderecoPostRequestBody {
    private UF uf;
    private String cidade;
    private String bairro;
}
