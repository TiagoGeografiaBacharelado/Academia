package com.example.SmartAcademy.repositories;

import com.example.SmartAcademy.models.ClientePlanoModels;
import java.util.List;
import java.util.Optional;

public interface ClientePlanoRepository {
    Optional<ClientePlanoModels> buscarPorCodigo(Integer id);
    List<ClientePlanoModels> buscarTodos();
    void adicionar(ClientePlanoModels clientePlano);
    void remover(Integer id);
    void atualizar(ClientePlanoModels clientePlano);
    List<ClientePlanoModels> buscarPorClienteId(int clienteId);
}