package com.desafio_votacao.desafio_votacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "votos",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"associado_id", "pauta_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associado_id", nullable = false)
    private Associado associado;

    @ManyToOne
    @JoinColumn(name = "pauta_id", nullable = false)
    private Pauta pauta;

    @Column(nullable = false)
    private Boolean voto; 
}
