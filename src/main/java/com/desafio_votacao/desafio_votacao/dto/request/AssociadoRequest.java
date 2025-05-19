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
    
    @Schema(description = "Email do associado", example = "joao.silva@email.com", required = true)
    private String email;
    
    @Schema(description = "Senha do associado", example = "senha123", required = true)
    private String senha;

    @Schema(description = "CPF do associado", example = "123.456.789-00", required = true)
    private String cpf;
} 