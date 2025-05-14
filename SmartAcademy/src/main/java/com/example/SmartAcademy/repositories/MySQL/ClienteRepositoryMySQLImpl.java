package com.example.SmartAcademy.repositories.mysql;

import com.example.SmartAcademy.models.ClienteModels;
import com.example.SmartAcademy.repositories.ClienteRepository;
import com.example.SmartAcademy.repositories.jpa.ClienteJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryMySQLImpl implements ClienteRepository {

    private final ClienteJPA clienteJPA;

    @Autowired
    public ClienteRepositoryMySQLImpl(ClienteJPA clienteJPA) {
        this.clienteJPA = clienteJPA;
    }

    @Override
    public Optional<ClienteModels> buscarPorCodigo(Integer id) {
        return clienteJPA.findById(id);
    }

    @Override
    public List<ClienteModels> buscarTodos() {
        return clienteJPA.findAll();
    }

    @Override
    public void adicionar(ClienteModels cliente) {
        clienteJPA.save(cliente);
    }

    @Override
    public void remover(Integer id) {
        clienteJPA.deleteById(id);
    }

    @Override
    public void atualizar(ClienteModels cliente) {
        clienteJPA.save(cliente);
    }

    @Override
    public Optional<ClienteModels> buscarPorCpf(String cpf) {
        return clienteJPA.findByCpf(cpf);
    }
}