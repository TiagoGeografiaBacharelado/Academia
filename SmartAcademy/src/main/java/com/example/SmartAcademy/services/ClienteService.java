package com.example.SmartAcademy.services;

import com.example.SmartAcademy.models.ClienteModels;
import com.example.SmartAcademy.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModels> listarTodos() {
        return clienteRepository.buscarTodos();
    }

    public Optional<ClienteModels> buscarPorId(Integer id) {
        return clienteRepository.buscarPorCodigo(id);
    }

    public ClienteModels criar(ClienteModels cliente) {
        // exemplo de validação simples: evitar CPF duplicado
        Optional<ClienteModels> existente = clienteRepository.buscarPorCpf(cliente.getCpf());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado: " + cliente.getCpf());
        }
        clienteRepository.adicionar(cliente);
        return cliente;
    }

    public ClienteModels atualizar(Integer id, ClienteModels cliente) {
        Optional<ClienteModels> existente = clienteRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id);
        }
        cliente.setId(id); // sincroniza ID
        clienteRepository.atualizar(cliente);
        return cliente;
    }

    public void deletar(Integer id) {
        Optional<ClienteModels> existente = clienteRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id);
        }
        clienteRepository.remover(id);
    }
}
