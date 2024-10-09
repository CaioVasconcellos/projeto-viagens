package viagens.web.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import viagens.web.api.domain.Pessoa;
import viagens.web.api.domain.PessoaEndereco;
import viagens.web.api.requests.PessoaEnderecoPostRequestBody;

@Mapper(componentModel = "spring")
public abstract class PessoaEnderecoMapper {

    public static final PessoaEnderecoMapper INSTANCE = Mappers.getMapper(PessoaEnderecoMapper.class);


    @Mapping(source = "pessoaEnderecoPostRequestBody.uf", target = "uf")
    @Mapping(source = "pessoaEnderecoPostRequestBody.cidade", target = "cidade")
    @Mapping(source = "pessoaEnderecoPostRequestBody.bairro", target = "bairro")

    public abstract PessoaEndereco toPessoaEndereco(PessoaEnderecoPostRequestBody pessoaEnderecoPostRequestBody, Pessoa pessoa);
}
