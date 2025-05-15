package com.desafio_votacao.desafio_votacao.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio_votacao.desafio_votacao.dto.request.VotoRequest;
import com.desafio_votacao.desafio_votacao.dto.response.VotoResponse;
import com.desafio_votacao.desafio_votacao.services.VotoService;

@RestController
@RequestMapping("/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    @Operation(summary = "Registrar voto")
    @ApiResponse(responseCode = "201", description = "Voto registrado com sucesso")
    public ResponseEntity<VotoResponse> votar(@RequestBody VotoRequest request) {
        return ResponseEntity.ok(votoService.registrarVoto(request));
    }

    @GetMapping("/resultado/{pautaId}")
    @Operation(summary = "Consultar resultado da votação")
    @ApiResponse(responseCode = "200", description = "Resultado da votação retornado com sucesso")
    public ResponseEntity<String> resultado(@PathVariable Long pautaId) {
        return ResponseEntity.ok(votoService.contarVotos(pautaId));
    }
}
