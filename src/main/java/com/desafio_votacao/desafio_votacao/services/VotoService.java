package com.desafio_votacao.desafio_votacao.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.Voto;
import com.desafio_votacao.desafio_votacao.repositories.VotoRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;
    private final SessaoVotacaoService sessaoVotacaoService;

    public Voto registrarVoto(Voto voto) {
        if (votoRepository.existsByAssociadoIdAndPautaId(voto.getAssociado().getId(), voto.getPauta().getId())) {
            throw new RuntimeException("Associado já votou nesta pauta");
        }
        return votoRepository.save(voto);
    }

    public String contarVotos(Long pautaId) {
        List<Voto> votos = votoRepository.findByPautaId(pautaId);
        long sim = votos.stream().filter(Voto::getVoto).count();
        long nao = votos.size() - sim;
        return "Sim: " + sim + ", Não: " + nao;
    }
}

