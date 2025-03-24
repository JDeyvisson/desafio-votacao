package com.desafio_votacao.desafio_votacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean votosim;
    
    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;
    
    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Usuario usuario;
}
