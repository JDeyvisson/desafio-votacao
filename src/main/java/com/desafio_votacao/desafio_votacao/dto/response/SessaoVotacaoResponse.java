package com.desafio_votacao.desafio_votacao.dto.response;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta para sessão de votação")
public class SessaoVotacaoResponse {
    @Schema(description = "ID da sessão", example = "1")
    private Long id;
    
    @Schema(description = "ID da pauta", example = "1")
    private Long pautaId;
    
    @Schema(description = "Data e hora de início da sessão", example = "2024-03-20T10:00:00")
    private LocalDateTime inicio;
    
    @Schema(description = "Data e hora de fim da sessão", example = "2024-03-20T11:00:00")
    private LocalDateTime fim;
} 