package com.desafio_votacao.desafio_votacao.dto.response;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta para pauta")
public class PautaResponse {
    @Schema(description = "ID da pauta", example = "1")
    private Long id;
    
    @Schema(description = "Título da pauta", example = "Implementação de novo sistema")
    private String titulo;
    
    @Schema(description = "Descrição da pauta", example = "Discussão sobre a implementação do novo sistema de votação")
    private String descricao;
} 