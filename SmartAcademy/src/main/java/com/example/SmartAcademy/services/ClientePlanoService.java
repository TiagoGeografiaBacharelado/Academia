package com.example.SmartAcademy.services;

import com.example.SmartAcademy.Interfaces.ClientePlanoRepository;
import com.example.SmartAcademy.models.ClientePlanoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientePlanoService {

    private final ClientePlanoRepository clientePlanoRepository;

    @Autowired
    public ClientePlanoService(ClientePlanoRepository clientePlanoRepository) {
        this.clientePlanoRepository = clientePlanoRepository;
    }

    public List<ClientePlanoModel> listarTodos() {
        return clientePlanoRepository.buscarTodos();
    }

    public Optional<ClientePlanoModel> buscarPorId(Long id) {
        return clientePlanoRepository.buscarPorCodigo(id);
    }

    public ClientePlanoModel criar(ClientePlanoModel dto) {
        clientePlanoRepository.adicionar(dto);
        return dto;
    }

    public ClientePlanoModel atualizar(Long id, ClientePlanoModel dto) {
        Optional<ClientePlanoModel> existente = clientePlanoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("ClientePlano não encontrado com ID: " + id);
        }
        dto.setId(id);
        clientePlanoRepository.atualizar(dto);
        return dto;
    }

    public void deletar(Long id) {
        Optional<ClientePlanoModel> existente = clientePlanoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("ClientePlano não encontrado com ID: " + id);
        }
        clientePlanoRepository.remover(id);
    }
}