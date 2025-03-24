package com.desafio_votacao.desafio_votacao.models;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sessao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Data e hora de abertura e fechamento da sessão
    private LocalDateTime inicio;
    private LocalDateTime fim;
    
    @OneToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;
    
    @OneToMany(mappedBy = "sessao", cascade = CascadeType.ALL)
    private List<Voto> votos;
}
