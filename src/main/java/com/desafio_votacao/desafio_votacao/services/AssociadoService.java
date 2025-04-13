package com.desafio_votacao.desafio_votacao.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.Associado;
import com.desafio_votacao.desafio_votacao.repositories.AssociadoRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository associadoRepository;

    public List<Associado> listarTodos() {
        return associadoRepository.findAll();
    }

    public Associado buscarPorId(Long id) {
        return associadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Associado não encontrado"));
    }

    public Associado cadastrarAssociado(Associado associado) {
        return associadoRepository.save(associado);
    }
}

