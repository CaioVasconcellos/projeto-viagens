package viagens.web.api.requestsdto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import viagens.web.api.requests.DestinoEnderecoPostRequestBody;
import viagens.web.api.requests.DestinoPostRequestBody;

@Data
public class DestinoPostRequestDTO {
    private DestinoPostRequestBody destinoPostRequestBody;
    private DestinoEnderecoPostRequestBody  destinoEnderecoPostRequestBody;
}
