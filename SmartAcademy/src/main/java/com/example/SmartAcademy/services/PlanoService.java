package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.PlanoRepository;
import com.example.SmartAcademy.models.PlanoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanoService {

    private final PlanoRepository planoRepository;

    @Autowired
    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<PlanoModel> listarTodos() {
        return planoRepository.buscarTodos();
    }

    public Optional<PlanoModel> buscarPorId(int id) {
        return planoRepository.buscarPorCodigo(id);
    }

    public PlanoModel atualizar(int id, PlanoModel dto) {
        Optional<PlanoModel> existente = planoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id);
        }
        dto.setId(id);
        planoRepository.atualizar(dto);
        return dto;
    }

    public PlanoModel criar(PlanoModel dto) {
        if (planoRepository.buscarPorCpf(dto.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf());
        }
        planoRepository.adicionar(dto);
        return dto;
    }

    public void deletar(int id) {
        Optional<PlanoModel> existente = planoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id);
        }
        planoRepository.remover(id);
    }
}
