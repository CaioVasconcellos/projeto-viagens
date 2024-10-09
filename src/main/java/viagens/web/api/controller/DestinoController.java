package viagens.web.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viagens.web.api.domain.Destino;
import viagens.web.api.requestsdto.DestinoPostRequestDTO;
import viagens.web.api.service.DestinoService;
import viagens.web.api.until.DateUntil;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("Destino")
@AllArgsConstructor
public class DestinoController {

    @Autowired
    private final DestinoService destinoService;
    private final DateUntil dateUntil;

    @Operation(summary = "Obter todos os destinos")
    @GetMapping
    public ResponseEntity<List<Destino>> obterTodosDestinos() {
        log.info(dateUntil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(destinoService.findAll());
    }

    @Operation(summary = "Criar destino")
    @PostMapping
    public ResponseEntity<Destino> criarDestino(@RequestBody DestinoPostRequestDTO destinoPostRequestDTO) {
        return new ResponseEntity<>(destinoService.saveAllInformations(destinoPostRequestDTO), HttpStatus.CREATED);
    }

}
