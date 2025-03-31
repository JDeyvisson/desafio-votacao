package com.desafio_votacao.desafio_votacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafio_votacao.desafio_votacao.models.Voto;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsByAssociadoIdAndPautaId(Long associadoId, Long pautaId);
    List<Voto> findByPautaId(Long pautaId);
}
