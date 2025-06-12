package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.ClienteModel;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteModel> buscarPorCodigo(Long id);
    List<ClienteModel> buscarTodos();
    void adicionar(ClienteModel clienteModel);
    void atualizar(ClienteModel clienteModel);
    void remover(Long id);
    Optional<ClienteModel> buscarPorCpf(String cpf);
}
