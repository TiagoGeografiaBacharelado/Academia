package com.example.SmartAcademy.repositories.mysql;

import com.example.SmartAcademy.models.ClientePlanoModels;
import com.example.SmartAcademy.Interfaces.ClientePlanoRepository;
import com.example.SmartAcademy.repositories.jpa.ClientePlanoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientePlanoRepositoryMySQLImpl implements ClientePlanoRepository {

    private final ClientePlanoJPA clientePlanoJPA;

    @Autowired
    public ClientePlanoRepositoryMySQLImpl(ClientePlanoJPA clientePlanoJPA) {
        this.clientePlanoJPA = clientePlanoJPA;
    }

    @Override
    public Optional<ClientePlanoModels> buscarPorCodigo(Integer id) {
        return clientePlanoJPA.findById(id);
    }

    @Override
    public List<ClientePlanoModels> buscarTodos() {
        return clientePlanoJPA.findAll();
    }

    @Override
    public void adicionar(ClientePlanoModels clientePlano) {
        clientePlanoJPA.save(clientePlano);
    }

    @Override
    public void remover(Integer id) {
        clientePlanoJPA.deleteById(id);
    }

    @Override
    public void atualizar(ClientePlanoModels clientePlano) {
        clientePlanoJPA.save(clientePlano);
    }

    @Override
    public List<ClientePlanoModels> buscarPorClienteId(int clienteId) {
        return clientePlanoJPA.findByClienteId(clienteId);
    }
}