package com.desafio_votacao.desafio_votacao.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio_votacao.desafio_votacao.models.Pauta;
import com.desafio_votacao.desafio_votacao.services.PautaService;
import java.util.List;

@RestController
@RequestMapping("/pautas")
@RequiredArgsConstructor
public class PautaController {

    private final PautaService pautaService;

    @GetMapping
    @Operation(summary = "Listar todas as pautas", description = "Retorna uma lista de todas as pautas disponíveis")
    @ApiResponse(responseCode = "200", description = "Lista de pautas retornada com sucesso")
    public ResponseEntity<List<Pauta>> listarPautas() {
        return ResponseEntity.ok(pautaService.listarPautas());
    }

    @PostMapping
    @Operation(summary = "Criar uma nova pauta", description = "Cria uma pauta com título e descrição")
    @ApiResponse(responseCode = "201", description = "Pauta criada com sucesso")
    public ResponseEntity<Pauta> criarPauta(@RequestBody Pauta pauta) {
        return ResponseEntity.ok(pautaService.criarPauta(pauta));
    }
}
