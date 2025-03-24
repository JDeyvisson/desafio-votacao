package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;

import com.desafio_votacao.desafio_votacao.models.Pauta;
import com.desafio_votacao.desafio_votacao.models.Sessao;
import com.desafio_votacao.desafio_votacao.repositories.PautaRepository;
import com.desafio_votacao.desafio_votacao.repositories.SessaoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final PautaRepository pautaRepository;

    public SessaoService(SessaoRepository sessaoVotacaoRepository, PautaRepository pautaRepository) {
        this.sessaoRepository = sessaoVotacaoRepository;
        this.pautaRepository = pautaRepository;
    }

    public Sessao abrirSessao(Long pautaId, Integer duracaoEmMinutos) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));

        Sessao sessao = new Sessao();
        sessao.setPauta(pauta);
        sessao.setInicio(LocalDateTime.now());
        sessao.setFim(LocalDateTime.now().plusMinutes(duracaoEmMinutos != null ? duracaoEmMinutos : 1));

        return sessaoRepository.save(sessao);
    }

    public Optional<Sessao> buscarPorId(Long id) {
        return sessaoRepository.findById(id);
    }
}
