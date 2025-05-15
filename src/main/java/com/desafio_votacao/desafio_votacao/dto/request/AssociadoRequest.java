package com.desafio_votacao.desafio_votacao.dto.request;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de requisição para criar um associado")
public class AssociadoRequest {
    @Schema(description = "Nome do associado", example = "João Silva", required = true)
    private String nome;
} 