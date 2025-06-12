package com.example.SmartAcademy.services;

import com.example.SmartAcademy.models.ClienteModel;
import com.example.SmartAcademy.interfaces.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> listarTodos() {
        return clienteRepository.buscarTodos();
    }

    public Optional<ClienteModel> buscarPorId(Long id) {
        return clienteRepository.buscarPorCodigo(id);
    }

    public ClienteModel criar(ClienteModel clienteModel) {
        clienteRepository.adicionar(clienteModel);
        return clienteModel;
    }

    public ClienteModel atualizar(Long id, ClienteModel clienteModel) {
        clienteModel.setId(id);
        clienteRepository.atualizar(clienteModel);
        return clienteModel;
    }

    public void deletar(Long id) {
        clienteRepository.remover(id);
    }
}
