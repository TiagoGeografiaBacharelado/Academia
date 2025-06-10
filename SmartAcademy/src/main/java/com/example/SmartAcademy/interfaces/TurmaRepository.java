package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.TurmaModel;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository {
    Optional<TurmaModel> buscarPorCodigo(Long id);
    List<TurmaModel> buscarTodos();
    void adicionar(TurmaModel model);
    void atualizar(TurmaModel model);
    void remover(Long id);
}
