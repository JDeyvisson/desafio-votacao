package com.desafio_votacao.desafio_votacao.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio_votacao.desafio_votacao.dto.response.SessaoVotacaoResponse;
import com.desafio_votacao.desafio_votacao.services.SessaoVotacaoService;

@RestController
@RequestMapping("/sessoes")
public class SessaoVotacaoController {

    private final SessaoVotacaoService sessaoVotacaoService;

    public SessaoVotacaoController(SessaoVotacaoService sessaoVotacaoService) {
        this.sessaoVotacaoService = sessaoVotacaoService;
    }

    @PostMapping("/{pautaId}")
    @Operation(summary = "Abrir sessão de votação")
    @ApiResponse(responseCode = "201", description = "Sessão de votação aberta com sucesso")
    public ResponseEntity<SessaoVotacaoResponse> abrirSessao(
            @PathVariable Long pautaId,
            @RequestParam(required = false) Integer minutos) {
        return ResponseEntity.ok(sessaoVotacaoService.abrirSessao(pautaId, minutos));
    }
}
