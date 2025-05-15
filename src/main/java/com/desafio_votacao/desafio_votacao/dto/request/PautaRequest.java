package com.desafio_votacao.desafio_votacao.dto.request;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de requisição para criar uma pauta")
public class PautaRequest {
    @Schema(description = "Título da pauta", example = "Implementação de novo sistema", required = true)
    private String titulo;
    
    @Schema(description = "Descrição da pauta", example = "Discussão sobre a implementação do novo sistema de votação")
    private String descricao;
} 