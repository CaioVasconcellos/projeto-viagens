package viagens.web.api.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import viagens.web.api.domain.PessoaEndereco;
import viagens.web.api.mapper.PessoaEnderecoMapper;
import viagens.web.api.repository.PessoaEnderecoRepository;
import viagens.web.api.requests.PessoaEnderecoPostRequestBody;

@Service
@RequiredArgsConstructor
public class PessoaEnderecoService {

    private final PessoaEnderecoRepository pessoaEnderecoRepository;

}
