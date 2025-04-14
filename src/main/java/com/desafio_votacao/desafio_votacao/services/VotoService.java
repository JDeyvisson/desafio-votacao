package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.SessaoVotacao;
import com.desafio_votacao.desafio_votacao.models.Voto;
import com.desafio_votacao.desafio_votacao.repositories.SessaoVotacaoRepository;
import com.desafio_votacao.desafio_votacao.repositories.VotoRepository;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class VotoService {

    private final VotoRepository votoRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    public VotoService(VotoRepository votoRepository, SessaoVotacaoRepository sessaoVotacaoRepository) {
        this.votoRepository = votoRepository;
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
    }

    public Voto registrarVoto(Voto voto) {

        if (votoRepository.existsByAssociadoIdAndPautaId(voto.getAssociado().getId(), voto.getPauta().getId())) {
            throw new RuntimeException("Associado já votou nesta pauta");
        }

        SessaoVotacao sessao = sessaoVotacaoRepository.findByPautaId(voto.getPauta().getId())
                .orElseThrow(() -> new RuntimeException("Sessão de votação não encontrada para a pauta"));

        LocalDateTime agora = LocalDateTime.now();
        if (agora.isBefore(sessao.getInicio()) || agora.isAfter(sessao.getFim())) {
            throw new RuntimeException("Sessão de votação está encerrada ou ainda não começou");
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
