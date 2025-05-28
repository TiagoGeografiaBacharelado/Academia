package com.example.SmartAcademy.Interfaces;

import com.example.SmartAcademy.models.ClientePlanoModel;

import java.util.List;
import java.util.Optional;

public interface ClientePlanoRepository {
    Optional<ClientePlanoModel> buscarPorCodigo(Long id);
    List<ClientePlanoModel> buscarTodos();
    void adicionar(ClientePlanoModel clientePlanoModel);
    void atualizar(ClientePlanoModel clientePlanoModel);
    void remover(Long id);
}