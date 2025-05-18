package com.desafio_votacao.desafio_votacao.services;

import org.springframework.stereotype.Service;
import com.desafio_votacao.desafio_votacao.models.Associado;
import com.desafio_votacao.desafio_votacao.repositories.AssociadoRepository;
import com.desafio_votacao.desafio_votacao.dto.request.AssociadoRequest;
import com.desafio_votacao.desafio_votacao.dto.response.AssociadoResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociadoService {

    private final AssociadoRepository associadoRepository;

    public AssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public List<AssociadoResponse> listarTodos() {
        return associadoRepository.findAll().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public Associado buscarPorId(Long id) {
        return associadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Associado não encontrado"));
    }

    public Associado buscarPorEmail(String email) {
        return associadoRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Associado não encontrado"));
    }

    public AssociadoResponse cadastrarAssociado(AssociadoRequest request) {
        if (associadoRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        Associado associado = new Associado();
        associado.setNome(request.getNome());
        associado.setEmail(request.getEmail());
        associado.setSenha(request.getSenha()); // In a real application, this should be encrypted
        return toResponse(associadoRepository.save(associado));
    }

    public AssociadoResponse toResponse(Associado associado) {
        return AssociadoResponse.builder()
            .id(associado.getId())
            .nome(associado.getNome())
            .email(associado.getEmail())
            .build();
    }
}

