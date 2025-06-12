package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.PlanoModel;
import java.util.List;
import java.util.Optional;

public interface PlanoRepository {
    Optional<PlanoModel> buscarPorCodigo(int id);
    List<PlanoModel> buscarTodos();
    void adicionar(PlanoModel planoModel);
    void atualizar(PlanoModel planoModel);
    void remover(int id);
    Optional<PlanoModel> buscarPorCpf(String cpf);
}
