package com.desafio_votacao.desafio_votacao.dto.request;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de requisição para criar uma sessão de votação")
public class SessaoVotacaoRequest {
    @Schema(description = "ID da pauta", example = "1", required = true)
    private Long pautaId;
    
    @Schema(description = "Data e hora de fim da sessão", example = "2024-03-20T11:00:00")
    private LocalDateTime fim;
} 