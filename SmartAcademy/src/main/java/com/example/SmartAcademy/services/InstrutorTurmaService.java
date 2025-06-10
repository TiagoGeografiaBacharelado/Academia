package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.InstrutorTurmaRepository;
import com.example.SmartAcademy.models.InstrutorTurmaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstrutorTurmaService {

    private final InstrutorTurmaRepository instrutorTurmaRepository;

    @Autowired
    public InstrutorTurmaService(InstrutorTurmaRepository instrutorTurmaRepository) {
        this.instrutorTurmaRepository = instrutorTurmaRepository;
    }

    public List<InstrutorTurmaModel> listarTodos() {
        return instrutorTurmaRepository.buscarTodos();
    }

    public Optional<InstrutorTurmaModel> buscarPorId(Long id) {
        return instrutorTurmaRepository.buscarPorCodigo(id);
    }

    public InstrutorTurmaModel criar(InstrutorTurmaModel model) {
        instrutorTurmaRepository.adicionar(model);
        return model;
    }

    public InstrutorTurmaModel atualizar(Long id, InstrutorTurmaModel model) {
        if (instrutorTurmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("InstrutorTurma não encontrada com ID: " + id);
        }
        model.setId(id);
        instrutorTurmaRepository.atualizar(model);
        return model;
    }

    public void deletar(Long id) {
        if (instrutorTurmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("InstrutorTurma não encontrada com ID: " + id);
        }
        instrutorTurmaRepository.remover(id);
    }
}
