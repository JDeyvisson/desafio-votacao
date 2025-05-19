package com.desafio_votacao.desafio_votacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "associados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Associado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, unique = true)
    private String cpf;
}
