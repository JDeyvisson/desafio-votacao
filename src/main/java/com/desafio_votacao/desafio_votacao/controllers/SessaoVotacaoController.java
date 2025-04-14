package com.desafio_votacao.desafio_votacao.controllers;


import com.desafio_votacao.desafio_votacao.models.SessaoVotacao;
import com.desafio_votacao.desafio_votacao.services.SessaoVotacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class SessaoVotacaoController {

    private final SessaoVotacaoService sessaoVotacaoService;

    public SessaoVotacaoController(SessaoVotacaoService sessaoVotacaoService) {
        this.sessaoVotacaoService = sessaoVotacaoService;
    }

    @PostMapping("/{pautaId}")
    @Operation(summary = "Abrir uma sessão de votação", description = "Abre uma nova sessão de votação para uma pauta")
    @ApiResponse(responseCode = "200", description = "Sessão aberta com sucesso")
    public ResponseEntity<SessaoVotacao> abrirSessao(@PathVariable Long pautaId,
                                                     @RequestParam(required = false) Integer minutos) {
        return ResponseEntity.ok(sessaoVotacaoService.abrirSessao(pautaId, minutos));
    }
}
