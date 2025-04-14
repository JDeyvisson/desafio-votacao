package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.Pauta;
import com.desafio_votacao.desafio_votacao.repositories.PautaRepository;
import java.util.List;

@Service
public class PautaService {
    
    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public List<Pauta> listarPautas() {
        return pautaRepository.findAll();
    }

    public Pauta criarPauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public Pauta buscarPorId(Long id) {
        return pautaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
    }
}
