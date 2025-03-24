package com.desafio_votacao.desafio_votacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio_votacao.desafio_votacao.models.Sessao;
import com.desafio_votacao.desafio_votacao.models.Usuario;
import com.desafio_votacao.desafio_votacao.models.Voto;


public interface VotoRepository extends JpaRepository<Voto, Long> {
    
      boolean existsBySessaoAndUsuario(Sessao sessao, Usuario usuario);
}
