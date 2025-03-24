package com.desafio_votacao.desafio_votacao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio_votacao.desafio_votacao.models.Voto;
import com.desafio_votacao.desafio_votacao.services.VotoService;


@RestController
@RequestMapping("/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public ResponseEntity<Voto> registrarVoto(@RequestParam Long usuarioId, @RequestParam Long sessaoId, @RequestParam boolean votosim) {
        return ResponseEntity.ok(votoService.registrarVoto(usuarioId, sessaoId, votosim));
    }
}
