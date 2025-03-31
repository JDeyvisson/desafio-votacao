package com.desafio_votacao.desafio_votacao.controllers;

import com.desafio_votacao.desafio_votacao.models.Associado;
import com.desafio_votacao.desafio_votacao.services.AssociadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/associados")
@RequiredArgsConstructor
public class AssociadoController {

    private final AssociadoService associadoService;

    @GetMapping
    @Operation(summary = "Listar todos os associados", description = "Retorna a lista de associados cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de associados retornada com sucesso")
    public ResponseEntity<List<Associado>> listarTodos() {
        return ResponseEntity.ok(associadoService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo associado", description = "Cadastra um associado com nome e CPF")
    @ApiResponse(responseCode = "201", description = "Associado cadastrado com sucesso")
    public ResponseEntity<Associado> cadastrarAssociado(@RequestBody Associado associado) {
        return ResponseEntity.ok(associadoService.cadastrarAssociado(associado));
    }
}

