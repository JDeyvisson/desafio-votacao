package com.desafio_votacao.desafio_votacao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafio_votacao.desafio_votacao.models.Pauta;
import com.desafio_votacao.desafio_votacao.services.PautaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public ResponseEntity<Pauta> criarPauta(@RequestBody Pauta pauta) {
        return ResponseEntity.ok(pautaService.salvar(pauta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pauta> buscarPauta(@PathVariable Long id) {
        Optional<Pauta> pauta = pautaService.buscarPorId(id);
        return pauta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Pauta>> listarPautas() {
        return ResponseEntity.ok(pautaService.listarTodas());
    }
}

