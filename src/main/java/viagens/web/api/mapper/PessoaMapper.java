package viagens.web.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import viagens.web.api.domain.Pessoa;
import viagens.web.api.domain.PessoaEndereco;
import viagens.web.api.domain.PessoaTelefone;
import viagens.web.api.requests.PessoaEnderecoPostRequestBody;
import viagens.web.api.requests.PessoaPostRequestBody;
import viagens.web.api.requests.PessoaPutRequestBody;
import viagens.web.api.requests.PessoaTelefonePostRequestBody;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PessoaMapper {
    public static final PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "sexo", target = "sexo")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    public abstract Pessoa toPessoa(PessoaPostRequestBody pessoaPostRequestBody);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "sexo", target = "sexo")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    public abstract Pessoa toPessoa(PessoaPutRequestBody pessoaPutRequestBody);


}