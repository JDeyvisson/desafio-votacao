package com.desafio_votacao.desafio_votacao.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.Pauta;
import com.desafio_votacao.desafio_votacao.models.SessaoVotacao;
import com.desafio_votacao.desafio_votacao.repositories.SessaoVotacaoRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessaoVotacaoService {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;

    public SessaoVotacao abrirSessao(Long pautaId, Integer minutos) {
        Pauta pauta = pautaService.buscarPorId(pautaId);
        SessaoVotacao sessao = SessaoVotacao.builder()
                .pauta(pauta)
                .inicio(LocalDateTime.now())
                .fim(LocalDateTime.now().plusMinutes(minutos != null ? minutos : 1))
                .build();
        return sessaoVotacaoRepository.save(sessao);
    }
}

