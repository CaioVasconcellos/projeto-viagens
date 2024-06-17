package viagens.web.api.requests;
import lombok.Data;
import viagens.web.api.until.TipoTelefone;

@Data
public class PessoaTelefonePostRequestBody {

    private String numero;
    private TipoTelefone tipoTelefone;
}
