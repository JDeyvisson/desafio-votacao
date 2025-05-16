package com.desafio_votacao.desafio_votacao.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio_votacao.desafio_votacao.dto.request.AssociadoRequest;
import com.desafio_votacao.desafio_votacao.dto.response.AssociadoResponse;
import com.desafio_votacao.desafio_votacao.services.AssociadoService;
import java.util.List;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    private final AssociadoService associadoService;

    public AssociadoController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os associados")
    @ApiResponse(responseCode = "200", description = "Lista de associados retornada com sucesso")
    public ResponseEntity<List<AssociadoResponse>> listarTodos() {
        return ResponseEntity.ok(associadoService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo associado")
    @ApiResponse(responseCode = "201", description = "Associado cadastrado com sucesso")
    public ResponseEntity<AssociadoResponse> cadastrarAssociado(@RequestBody AssociadoRequest request) {
        return ResponseEntity.ok(associadoService.cadastrarAssociado(request));
    }
    
    @PostMapping("/login")
    @Operation(summary = "Realizar login do associado")
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso")
    public ResponseEntity<AssociadoResponse> login(@RequestBody AssociadoRequest request) {
        var associado = associadoService.buscarPorEmail(request.getEmail());
        if (!associado.getSenha().equals(request.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }
        return ResponseEntity.ok(associadoService.toResponse(associado));
    }
}

