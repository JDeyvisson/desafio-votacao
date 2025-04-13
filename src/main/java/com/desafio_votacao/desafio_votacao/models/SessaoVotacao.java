package com.desafio_votacao.desafio_votacao.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessoes_votacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessaoVotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pauta_id", nullable = false)
    private Pauta pauta;

    @Column(nullable = false, updatable = false)
    private LocalDateTime inicio = LocalDateTime.now();
    
    @Column(nullable = false)
    private LocalDateTime fim;
}
