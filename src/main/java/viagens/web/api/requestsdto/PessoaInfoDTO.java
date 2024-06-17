package viagens.web.api.requestsdto;

import lombok.Data;
import viagens.web.api.until.UF;

@Data
public class PessoaInfoDTO {
    private String nome;
    private UF uf;
    private String cidade;

}
