package com.desafio_votacao.desafio_votacao.dto.request;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de requisição para registrar um voto")
public class VotoRequest {
    @Schema(description = "ID do associado", example = "1", required = true)
    private Long associadoId;
    
    @Schema(description = "ID da pauta", example = "1", required = true)
    private Long pautaId;
    
    @Schema(description = "Valor do voto (true para sim, false para não)", example = "true", required = true)
    private Boolean voto;
} 