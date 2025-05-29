package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.TurmaRepository;
import com.example.SmartAcademy.models.TurmaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TurmaService {

    private final TurmaRepository turmaRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<TurmaModel> listarTodos() {
        return turmaRepository.buscarTodas();
    }

    public Optional<TurmaModel> buscarPorId(Long id) {
        return turmaRepository.buscarPorCodigo(id);
    }

    public TurmaModel criar(TurmaModel dto) {
        turmaRepository.adicionar(dto);
        return dto;
    }

    public TurmaModel atualizar(Long id, TurmaModel dto) {
        if (turmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Turma não encontrada com ID: " + id);
        }
        dto.setId(id);
        turmaRepository.atualizar(dto);
        return dto;
    }

    public void deletar(Long id) {
        if (turmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Turma não encontrada com ID: " + id);
        }
        turmaRepository.remover(id);
    }
}
