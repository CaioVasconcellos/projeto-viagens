package viagens.web.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import viagens.web.api.domain.Destino;
import viagens.web.api.domain.DestinoEndereco;
import viagens.web.api.requests.DestinoEnderecoPostRequestBody;

@Mapper(componentModel = "spring")
public abstract class DestinoEnderecoMapper {

    public static final DestinoEnderecoMapper INSTANCE = Mappers.getMapper(DestinoEnderecoMapper.class);


    @Mapping(source = "destinoEnderecoPostRequestBody.uf", target = "uf")
    @Mapping(source = "destinoEnderecoPostRequestBody.cidade", target = "cidade")
    @Mapping(source = "destinoEnderecoPostRequestBody.bairro", target = "bairro")

    public abstract DestinoEndereco toDestinoEndereco(DestinoEnderecoPostRequestBody destinoEnderecoPostRequestBody, Destino destino);
}

