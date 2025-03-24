package com.desafio_votacao.desafio_votacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pauta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;
    
    // Relacionamento opcional com a Sessão de votação
    @OneToOne(mappedBy = "pauta", cascade = CascadeType.ALL)
    private Sessao sessao;
}

