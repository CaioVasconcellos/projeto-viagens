package viagens.web.api.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DestinoPostRequestBody {
    @Schema(description = "Nome do Destino", example = "Casa no Rio de Janeiro")
    private String nome;
    @Schema(description = "Descrição do Destino", example = "Belas praias")
    private String descricao;

}
