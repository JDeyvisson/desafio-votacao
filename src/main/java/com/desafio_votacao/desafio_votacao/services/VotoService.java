package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;

import com.desafio_votacao.desafio_votacao.models.Sessao;
import com.desafio_votacao.desafio_votacao.models.Voto;
import com.desafio_votacao.desafio_votacao.models.Usuario;
import com.desafio_votacao.desafio_votacao.repositories.VotoRepository;


@Service
public class VotoService {

    private final VotoRepository votoRepository;
    private final SessaoService sessaoService;
    private final UsuarioService usuarioService;

    public VotoService(VotoRepository votoRepository, SessaoService sessaoService, UsuarioService usuarioService) {
        this.votoRepository = votoRepository;
        this.sessaoService = sessaoService;
        this.usuarioService = usuarioService;
    }

    public Voto registrarVoto(Long usuarioId, Long sessaoId, boolean votosim) {
        Sessao sessao = sessaoService.buscarPorId(sessaoId)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        Usuario usuario = usuarioService.buscarPorId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Impede que o mesmo usuário vote duas vezes na mesma pauta
        if (votoRepository.existsBySessaoAndUsuario(sessao, usuario)) {
            throw new RuntimeException("Usuário já votou nesta pauta");
        }

        Voto voto = Voto.builder()
                .sessao(sessao)
                .usuario(usuario)
                .votosim(votosim)
                .build();

        return votoRepository.save(voto);
    }
}
