package com.desafio_votacao.desafio_votacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio_votacao.desafio_votacao.models.Associado;
import java.util.Optional;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    Optional<Associado> findByEmail(String email);
}
