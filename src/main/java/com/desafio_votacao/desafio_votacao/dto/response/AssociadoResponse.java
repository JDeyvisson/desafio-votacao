package com.desafio_votacao.desafio_votacao.dto.response;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de resposta para associado")
public class AssociadoResponse {
    @Schema(description = "ID do associado", example = "1")
    private Long id;
    
    @Schema(description = "Nome do associado", example = "João Silva")
    private String nome;
    
    @Schema(description = "Email do associado", example = "joao.silva@email.com")
    private String email;

    @Schema(description = "CPF do associado", example = "123.456.789-00")
    private String cpf;
} 