package com.desafio_votacao.desafio_votacao.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio_votacao.desafio_votacao.dto.request.PautaRequest;
import com.desafio_votacao.desafio_votacao.dto.response.PautaResponse;
import com.desafio_votacao.desafio_votacao.services.PautaService;
import java.util.List;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as pautas")
    @ApiResponse(responseCode = "200", description = "Lista de pautas retornada com sucesso")
    public ResponseEntity<List<PautaResponse>> listarPautas() {
        return ResponseEntity.ok(pautaService.listarPautas());
    }

    @PostMapping
    @Operation(summary = "Criar nova pauta")
    @ApiResponse(responseCode = "201", description = "Pauta criada com sucesso")
    public ResponseEntity<PautaResponse> criarPauta(@RequestBody PautaRequest request) {
        return ResponseEntity.ok(pautaService.criarPauta(request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir pauta")
    @ApiResponse(responseCode = "204", description = "Pauta excluída com sucesso")
    public ResponseEntity<Void> excluirPauta(@PathVariable Long id) {
        pautaService.excluirPauta(id);
        return ResponseEntity.noContent().build();
    }
}
