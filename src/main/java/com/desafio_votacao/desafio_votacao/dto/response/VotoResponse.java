package com.desafio_votacao.desafio_votacao.dto.response;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta para voto")
public class VotoResponse {
    @Schema(description = "ID do voto", example = "1")
    private Long id;
    
    @Schema(description = "ID do associado", example = "1")
    private Long associadoId;
    
    @Schema(description = "ID da pauta", example = "1")
    private Long pautaId;
    
    @Schema(description = "Valor do voto (true para sim, false para não)", example = "true")
    private Boolean voto;
} 