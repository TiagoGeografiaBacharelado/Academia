package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.AtividadeRepository;
import com.example.SmartAcademy.models.AtividadeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;

    @Autowired
    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    public List<AtividadeModel> listarTodos() {
        return atividadeRepository.buscarTodos();
    }

    public Optional<AtividadeModel> buscarPorId(int id) {
        return atividadeRepository.buscarPorCodigo(id);
    }

    public AtividadeModel atualizar(int id, AtividadeModel dto) {
        AtividadeModel existente = atividadeRepository.buscarPorCodigo(id)
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada com ID: " + id));

        existente.setNome(dto.getNome());
        existente.setDescricao(dto.getDescricao());
        existente.setDuracaoMinutos(dto.getDuracaoMinutos());
        existente.setNivel(dto.getNivel());
        existente.setTipo(dto.getTipo());

        atividadeRepository.atualizar(existente);
        return existente;
    }

    public AtividadeModel criar(AtividadeModel dto) {
        atividadeRepository.adicionar(dto);
        return dto;
    }

    public void deletar(int id) {
        AtividadeModel existente = atividadeRepository.buscarPorCodigo(id)
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada com ID: " + id));

        atividadeRepository.remover(id);
    }
}