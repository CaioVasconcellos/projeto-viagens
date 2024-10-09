package viagens.web.api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import viagens.web.api.domain.Destino;
import viagens.web.api.domain.DestinoEndereco;
import viagens.web.api.mapper.DestinoEnderecoMapper;
import viagens.web.api.mapper.DestinoMapper;
import viagens.web.api.repository.DestinoEnderecoRepository;
import viagens.web.api.repository.DestinoRepository;
import viagens.web.api.requests.DestinoPostRequestBody;
import viagens.web.api.requestsdto.DestinoPostRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinoService {

    private final DestinoRepository destinoRepository;
    private final DestinoEnderecoRepository destinoEnderecoRepository;

    public Destino save(DestinoPostRequestBody destinoPostRequestBody) {
        Destino destino = DestinoMapper.INSTANCE.toDestino(destinoPostRequestBody);
        return destinoRepository.save(destino);
    }

    @Transactional
    public Destino saveAllInformations(DestinoPostRequestDTO destinoPostRequestDTO) {
        Destino destino = save(destinoPostRequestDTO.getDestinoPostRequestBody());
        DestinoEndereco destinoEndereco = DestinoEnderecoMapper.INSTANCE.toDestinoEndereco(destinoPostRequestDTO.getDestinoEnderecoPostRequestBody(), destino);
        destinoEndereco.setDestino(destino);
        destinoEnderecoRepository.save(destinoEndereco);
        return destino;
    }

    public List<Destino> findAll() {
        return destinoRepository.findAll();
    }


}
