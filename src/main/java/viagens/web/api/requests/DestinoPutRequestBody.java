package viagens.web.api.requests;


import lombok.Data;

@Data
public class DestinoPutRequestBody {

    private long id;
    private String nome;
    private String descricao;
}
