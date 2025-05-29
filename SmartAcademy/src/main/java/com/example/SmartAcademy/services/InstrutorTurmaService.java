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

    public InstrutorTurmaModel criar(InstrutorTurmaModel dto) {
        instrutorTurmaRepository.adicionar(dto);
        return dto;
    }

    public InstrutorTurmaModel atualizar(Long id, InstrutorTurmaModel dto) {
        if (instrutorTurmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Vínculo Instrutor-Turma não encontrado com ID: " + id);
        }
        dto.setId(id);
        instrutorTurmaRepository.atualizar(dto);
        return dto;
    }

    public void deletar(Long id) {
        if (instrutorTurmaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Vínculo Instrutor-Turma não encontrado com ID: " + id);
        }
        instrutorTurmaRepository.remover(id);
    }
}
