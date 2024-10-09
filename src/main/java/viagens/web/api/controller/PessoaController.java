package viagens.web.api.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viagens.web.api.domain.Pessoa;
import viagens.web.api.requests.PessoaPutRequestBody;
import viagens.web.api.requestsdto.PessoaInfoDTO;
import viagens.web.api.requestsdto.PessoaPostRequestDTO;
import viagens.web.api.service.PessoaService;
import viagens.web.api.until.DateUntil;
import viagens.web.api.until.UF;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("Pessoa")
@AllArgsConstructor
public class PessoaController {

    @Autowired
    private final PessoaService pessoaService;
    private final DateUntil dateUntil;


    @Operation(summary = "Obter todos os usuários")
    @GetMapping()
    public ResponseEntity<List<Pessoa>> list(){
        log.info(dateUntil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @Operation(summary = "Obter usuários pelo nome")
    @GetMapping(path = "/findNome")
    public ResponseEntity<List<Pessoa>> findByNome(@RequestParam String nome){
        log.info(dateUntil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(pessoaService.findByNome(nome));
    }

    @Operation(summary = "Obter usuários pelo id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        log.info(dateUntil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(pessoaService.findByIdOrThrowsBadRequestException(id));
    }

    @Operation(summary = "Obter usuário pelo email")
    @GetMapping(path = "/findEmail")
    public ResponseEntity<Pessoa> findByEmail (@RequestParam String email){
        log.info(dateUntil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(pessoaService.findByEmail(email));
    }

    @Operation(summary = "Obter usuários pelo UF")
    @GetMapping(path = "/findAllUf")
    public ResponseEntity<List<PessoaInfoDTO>> findByUf(@RequestParam UF uf){
        log.info(dateUntil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(pessoaService.findByUf(uf));
    }

    @Operation(summary = "Deletar usuário")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Long id){
        pessoaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping()
//    public ResponseEntity<Pessoa> save(@RequestBody PessoaPostRequestBody pessoaPostRequestBody) {
//        return new ResponseEntity<>(pessoaService.save(pessoaPostRequestBody), HttpStatus.CREATED);
//    }

    @Operation(summary = "Criar usuário")
    @PostMapping
    public ResponseEntity<Pessoa> saveAllInformations (@RequestBody PessoaPostRequestDTO pessoaRequestDTO){
        return new ResponseEntity<>(pessoaService.saveAllInformations(pessoaRequestDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar usuário")
    @PutMapping()
    public ResponseEntity<Void> putPessoa (@RequestBody PessoaPutRequestBody pessoaPutRequestBody) {
        pessoaService.replace(pessoaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
