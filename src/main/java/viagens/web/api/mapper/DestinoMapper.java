package viagens.web.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import viagens.web.api.domain.Destino;
import viagens.web.api.requests.DestinoPostRequestBody;
import viagens.web.api.requests.DestinoPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class DestinoMapper {
    public static DestinoMapper INSTANCE = Mappers.getMapper(DestinoMapper.class);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "descricao", target = "descricao")
    public abstract Destino toDestino (DestinoPostRequestBody destinoPostRequestBody);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "descricao", target = "descricao")
    public abstract Destino toDestino (DestinoPutRequestBody destinoPutRequestBody);
}
