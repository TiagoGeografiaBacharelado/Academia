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
        return turmaRepository.buscarTodos();
    }

    public Optional<TurmaModel> buscarPorId(Long id) {
        return turmaRepository.buscarPorCodigo(id);
    }

    public TurmaModel criar(TurmaModel model) {
        turmaRepository.adicionar(model);
        return model;
    }

    public TurmaModel atualizar(Long id, TurmaModel model) {
        if (turmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Turma não encontrada com ID: " + id);
        }
        model.setIdTurma(id);
        turmaRepository.atualizar(model);
        return model;
    }

    public void deletar(Long id) {
        if (turmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Turma não encontrada com ID: " + id);
        }
        turmaRepository.remover(id);
    }
}