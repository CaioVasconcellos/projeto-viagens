package viagens.web.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import viagens.web.api.domain.Pessoa;
import viagens.web.api.domain.PessoaTelefone;
import viagens.web.api.requests.PessoaTelefonePostRequestBody;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public abstract class PessoaTelefoneMapper {

    public static final PessoaTelefoneMapper INSTANCE = Mappers.getMapper(PessoaTelefoneMapper.class);

    @Mapping(source = "pessoaTelefonePostRequestBody.numero", target = "numero")
    @Mapping(source = "pessoaTelefonePostRequestBody.tipoTelefone", target = "tipoTelefone")
    @Mapping(target = "pessoa", source = "pessoa")
    public abstract PessoaTelefone toPessoaTelefone (PessoaTelefonePostRequestBody pessoaTelefonePostRequestBody, Pessoa pessoa);

    public List<PessoaTelefone> toPessoaTelefoneList(List<PessoaTelefonePostRequestBody> dtos, Pessoa pessoa) {
        List<PessoaTelefone> pessoaTelefones = new ArrayList<>();
        for (PessoaTelefonePostRequestBody dto : dtos) {
            pessoaTelefones.add(toPessoaTelefone(dto, pessoa));
        }
        return pessoaTelefones;
    }
}
