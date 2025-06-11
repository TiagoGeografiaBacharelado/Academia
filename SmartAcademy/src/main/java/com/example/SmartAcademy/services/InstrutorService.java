package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.InstrutorRepository;
import com.example.SmartAcademy.models.InstrutorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstrutorService {

    private final InstrutorRepository instrutorRepository;

    @Autowired
    public InstrutorService(InstrutorRepository instrutorRepository) {
        this.instrutorRepository = instrutorRepository;
    }

    public List<InstrutorModel> listarTodos() {
        return instrutorRepository.buscarTodos();
    }

    public Optional<InstrutorModel> buscarPorId(Long id) {
        return instrutorRepository.buscarPorCodigo(id);
    }

    public InstrutorModel criar(InstrutorModel model) {
        instrutorRepository.adicionar(model);
        return model;
    }

    public InstrutorModel atualizar(Long id, InstrutorModel model) {
        if (instrutorRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Instrutor não encontrado com ID: " + id);
        }
        model.setIdInstrutor(id);
        instrutorRepository.atualizar(model);
        return model;
    }

    public void deletar(Long id) {
        if (instrutorRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Instrutor não encontrado com ID: " + id);
        }
        instrutorRepository.remover(id);
    }
}