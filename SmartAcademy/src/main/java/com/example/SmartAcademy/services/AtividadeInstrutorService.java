package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.AtividadeInstrutorRepository;
import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AtividadeInstrutorService {

    private final AtividadeInstrutorRepository atividadeInstrutorRepository;

    @Autowired
    public AtividadeInstrutorService(AtividadeInstrutorRepository atividadeInstrutorRepository) {
        this.atividadeInstrutorRepository = atividadeInstrutorRepository;
    }

    public List<AtividadeInstrutorModel> listarTodos() {
        return atividadeInstrutorRepository.buscarTodos();
    }

    public Optional<AtividadeInstrutorModel> buscarPorId(int id) {
        return atividadeInstrutorRepository.buscarPorCodigo(id);
    }

    public AtividadeInstrutorModel criar(AtividadeInstrutorModel dto) {
        if (atividadeInstrutorRepository.buscarPorCpf(dto.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf());
        }
        atividadeInstrutorRepository.adicionar(dto);
        return dto;
    }

    public AtividadeInstrutorModel atualizar(int id, AtividadeInstrutorModel dto) {
        Optional<AtividadeInstrutorModel> existente = atividadeInstrutorRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("AtividadeInstrutor não encontrado com ID: " + id);
        }
        dto.setId(id);
        atividadeInstrutorRepository.atualizar(dto);
        return dto;
    }

    public void deletar(int id) {
        Optional<AtividadeInstrutorModel> existente = atividadeInstrutorRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("AtividadeInstrutor não encontrado com ID: " + id);
        }
        atividadeInstrutorRepository.remover(id);
    }
}
