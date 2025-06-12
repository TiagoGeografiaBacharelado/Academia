package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.AtividadePlanoRepository;
import com.example.SmartAcademy.models.AtividadePlanoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AtividadePlanoService {

    private final AtividadePlanoRepository atividadePlanoRepository;

    @Autowired
    public AtividadePlanoService(AtividadePlanoRepository atividadePlanoRepository) {
        this.atividadePlanoRepository = atividadePlanoRepository;
    }

    public List<AtividadePlanoModel> listarTodos() {
        return atividadePlanoRepository.buscarTodos();
    }

    public Optional<Optional<AtividadePlanoModel>> buscarPorId(int id) {
        return Optional.ofNullable(atividadePlanoRepository.buscarPorCodigo(id));
    }


    public AtividadePlanoModel atualizar(int id, AtividadePlanoModel dto) {
        Optional<AtividadePlanoModel> existente = atividadePlanoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id);
        }
        dto.setId(id);
        atividadePlanoRepository.atualizar(dto);
        return dto;
    }

    public AtividadePlanoModel criar(AtividadePlanoModel dto) {
        List<AtividadePlanoModel> lista = atividadePlanoRepository.buscarPorCpf(dto.getCpf());
        if (!lista.isEmpty()) {
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf());
        }
        atividadePlanoRepository.adicionar(dto);
        return dto;
    }

    public void deletar(int id) {
        Optional<AtividadePlanoModel> existente = atividadePlanoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id);
        }
        atividadePlanoRepository.remover(id);
    }


}
