package com.desafio_votacao.desafio_votacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio_votacao.desafio_votacao.models.Associado;


public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}
