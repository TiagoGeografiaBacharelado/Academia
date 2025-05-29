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

    public InstrutorModel criar(InstrutorModel dto) {
        if (instrutorRepository.buscarPorCpf(dto.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf());
        }
        instrutorRepository.adicionar(dto);
        return dto;
    }

    public InstrutorModel atualizar(Long id, InstrutorModel dto) {
        if (instrutorRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Instrutor não encontrado com ID: " + id);
        }
        dto.setId(id);
        instrutorRepository.atualizar(dto);
        return dto;
    }

    public void deletar(Long id) {
        if (instrutorRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Instrutor não encontrado com ID: " + id);
        }
        instrutorRepository.remover(id);
    }
}
