package viagens.web.api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import viagens.web.api.domain.Pessoa;
import viagens.web.api.domain.PessoaEndereco;
import viagens.web.api.domain.PessoaTelefone;
import viagens.web.api.handler.NotFoundException;
import viagens.web.api.mapper.PessoaEnderecoMapper;
import viagens.web.api.mapper.PessoaMapper;
import viagens.web.api.mapper.PessoaTelefoneMapper;
import viagens.web.api.repository.PessoaEnderecoRepository;
import viagens.web.api.repository.PessoaRepository;
import viagens.web.api.repository.PessoaTelefoneRepository;
import viagens.web.api.requests.*;
import viagens.web.api.requestsdto.PessoaInfoDTO;
import viagens.web.api.requestsdto.PessoaPostRequestDTO;
import viagens.web.api.until.UF;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaEnderecoRepository pessoaEnderecoRepository;
    private final PessoaTelefoneRepository pessoaTelefoneRepository;

    public viagens.web.api.domain.Pessoa save(PessoaPostRequestBody pessoaPostRequestBody){
        Pessoa pessoa = PessoaMapper.INSTANCE.toPessoa(pessoaPostRequestBody);
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa saveAllInformations(PessoaPostRequestDTO pessoaRequestDTO) {
        Pessoa savedPessoa = save(pessoaRequestDTO.getPessoaPostRequestBody());
        PessoaEndereco pessoaEndereco = PessoaEnderecoMapper.INSTANCE.toPessoaEndereco(pessoaRequestDTO.getPessoaEnderecoPostRequestBody(), savedPessoa);
        List<PessoaTelefone> pessoaTelefones = PessoaTelefoneMapper.INSTANCE.toPessoaTelefoneList(pessoaRequestDTO.getPessoaTelefonePostRequestBody(), savedPessoa);
        for (PessoaTelefone p : pessoaTelefones) {
            p.setPessoa(savedPessoa);
            pessoaTelefoneRepository.save(p);
        }
        pessoaEndereco.setPessoa(savedPessoa);

        pessoaEnderecoRepository.save(pessoaEndereco);
        return savedPessoa;
    }

    public List<PessoaInfoDTO> findByUf (UF uf){
        List<Pessoa> pessoas = pessoaRepository.findByUF(uf);
        List<PessoaInfoDTO> pessoaInfoDTOs = new ArrayList<>();
        for (Pessoa p : pessoas) {
            PessoaEndereco endereco = p.getPessoaEndereco();
            PessoaInfoDTO dto = new PessoaInfoDTO();
            dto.setNome(p.getNome());
            dto.setUf(endereco.getUf());
            dto.setCidade(endereco.getCidade());
            pessoaInfoDTOs.add(dto);
        }
        return pessoaInfoDTOs;
    }


    public void deleteById(Long id){
        pessoaRepository.delete(findByIdOrThrowsBadRequestException(id));
    }
    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    public List<Pessoa> findByNome(String nome){
        return pessoaRepository.findByNome(nome);
    }
    public Pessoa findByIdOrThrowsBadRequestException(Long id){
        return pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void replace(PessoaPutRequestBody pessoaPutRequestBody){
        Pessoa savePessoa = findByIdOrThrowsBadRequestException(pessoaPutRequestBody.getId());
        Pessoa pessoa = PessoaMapper.INSTANCE.toPessoa(pessoaPutRequestBody);
        pessoa.setId(savePessoa.getId());
        pessoaRepository.save(pessoa);
    }
    public Pessoa findByEmail(String email){
        return pessoaRepository.findByEmail(email);
    }
}
