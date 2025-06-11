package com.example.SmartAcademy.services;

import com.example.SmartAcademy.interfaces.SalaRepository;
import com.example.SmartAcademy.models.SalaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalaService {

    private final SalaRepository salaRepository;

    @Autowired
    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<SalaModel> listarTodos() {
        return salaRepository.buscarTodos();
    }

    public Optional<SalaModel> buscarPorId(Long id) {
        return salaRepository.buscarPorCodigo(id);
    }

    public SalaModel criar(SalaModel model) {
        salaRepository.adicionar(model);
        return model;
    }

    public SalaModel atualizar(Long id, SalaModel model) {
        if (salaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Sala não encontrada com ID: " + id);
        }
        model.setIdSala(id);
        salaRepository.atualizar(model);
        return model;
    }

    public void deletar(Long id) {
        if (salaRepository.buscarPorCodigo(id).isEmpty()) {
            throw new IllegalArgumentException("Sala não encontrada com ID: " + id);
        }
        salaRepository.remover(id);
    }
}