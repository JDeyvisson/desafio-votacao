package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.Voto;
import com.desafio_votacao.desafio_votacao.models.SessaoVotacao;
import com.desafio_votacao.desafio_votacao.repositories.VotoRepository;
import com.desafio_votacao.desafio_votacao.repositories.SessaoVotacaoRepository;
import com.desafio_votacao.desafio_votacao.dto.request.VotoRequest;
import com.desafio_votacao.desafio_votacao.dto.response.VotoResponse;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VotoService {

    private final VotoRepository votoRepository;
    private final AssociadoService associadoService;
    private final PautaService pautaService;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    public VotoService(VotoRepository votoRepository, AssociadoService associadoService, PautaService pautaService, SessaoVotacaoRepository sessaoVotacaoRepository) {
        this.votoRepository = votoRepository;
        this.associadoService = associadoService;
        this.pautaService = pautaService;
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
    }

    public VotoResponse registrarVoto(VotoRequest request) {
        Voto voto = Voto.builder()
                .associado(associadoService.buscarPorId(request.getAssociadoId()))
                .pauta(pautaService.buscarPorId(request.getPautaId()))
                .voto(request.getVoto())
                .build();
        return toResponse(votoRepository.save(voto));
    }

    public String contarVotos(Long pautaId) {
        List<Voto> votos = votoRepository.findByPautaId(pautaId);
        long votosSim = votos.stream().filter(v -> v.getVoto()).count();
        long votosNao = votos.size() - votosSim;
        return String.format("Resultado da votação: %d votos SIM, %d votos NÃO", votosSim, votosNao);
    }

    public boolean podeVotar(Long associadoId, Long pautaId) {
     
        if (votoRepository.existsByAssociadoIdAndPautaId(associadoId, pautaId)) {
            return false;
        }

        
        Optional<SessaoVotacao> sessao = sessaoVotacaoRepository.findByPautaId(pautaId);
        if (sessao.isEmpty()) {
            return false;
        }

    
        return sessao.get().getFim().isAfter(LocalDateTime.now());
    }

    private VotoResponse toResponse(Voto voto) {
        return VotoResponse.builder()
            .id(voto.getId())
            .associadoId(voto.getAssociado().getId())
            .pautaId(voto.getPauta().getId())
            .voto(voto.getVoto())
            .build();
    }
}
