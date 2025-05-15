package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.Pauta;
import com.desafio_votacao.desafio_votacao.repositories.PautaRepository;
import com.desafio_votacao.desafio_votacao.dto.request.PautaRequest;
import com.desafio_votacao.desafio_votacao.dto.response.PautaResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PautaService {
    
    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public List<PautaResponse> listarPautas() {
        return pautaRepository.findAll().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public PautaResponse criarPauta(PautaRequest request) {
        Pauta pauta = new Pauta();
        pauta.setTitulo(request.getTitulo());
        pauta.setDescricao(request.getDescricao());
        return toResponse(pautaRepository.save(pauta));
    }

    public Pauta buscarPorId(Long id) {
        return pautaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
    }

    private PautaResponse toResponse(Pauta pauta) {
        return PautaResponse.builder()
            .id(pauta.getId())
            .titulo(pauta.getTitulo())
            .descricao(pauta.getDescricao())
            .build();
    }
}
