package com.desafio_votacao.desafio_votacao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafio_votacao.desafio_votacao.models.Sessao;
import com.desafio_votacao.desafio_votacao.services.SessaoService;

import java.util.Optional;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping("/abrir/{pautaId}")
    public ResponseEntity<Sessao> abrirSessao(@PathVariable Long pautaId, @RequestParam(required = false) Integer duracaoEmMinutos) {
        return ResponseEntity.ok(sessaoService.abrirSessao(pautaId, duracaoEmMinutos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sessao> buscarSessao(@PathVariable Long id) {
        Optional<Sessao> sessao = sessaoService.buscarPorId(id);
        return sessao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
