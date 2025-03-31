package com.desafio_votacao.desafio_votacao.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio_votacao.desafio_votacao.models.Voto;
import com.desafio_votacao.desafio_votacao.services.VotoService;

@RestController
@RequestMapping("/votos")
@RequiredArgsConstructor
public class VotoController {

    private final VotoService votoService;

    @PostMapping
    @Operation(summary = "Registrar um voto", description = "Registra um voto para uma pauta.")
    @ApiResponse(responseCode = "200", description = "Voto registrado com sucesso")
    public ResponseEntity<Voto> votar(@RequestBody Voto voto) {
        return ResponseEntity.ok(votoService.registrarVoto(voto));
    }

    @GetMapping("/{pautaId}/resultado")
    @Operation(summary = "Consultar resultado dos votos", description = "Retorna o resultado da votação de uma pauta específica.")
    @ApiResponse(responseCode = "200", description = "Resultado retornado com sucesso")
    public ResponseEntity<String> resultado(@PathVariable Long pautaId) {
        return ResponseEntity.ok(votoService.contarVotos(pautaId));
    }
}
