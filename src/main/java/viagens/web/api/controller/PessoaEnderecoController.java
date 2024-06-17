package viagens.web.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import viagens.web.api.service.PessoaEnderecoService;

@Log4j2
@RestController
@RequestMapping("PessoaEndereco")
@AllArgsConstructor
public class PessoaEnderecoController {
    @Autowired
    private PessoaEnderecoService pessoaEnderecoService;


}
