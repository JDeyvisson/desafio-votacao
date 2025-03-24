package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;

import com.desafio_votacao.desafio_votacao.models.Pauta;
import com.desafio_votacao.desafio_votacao.repositories.PautaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta salvar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public Optional<Pauta> buscarPorId(Long id) {
        return pautaRepository.findById(id);
    }

    public List<Pauta> listarTodas() {
        return pautaRepository.findAll();
    }
}
