package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.SalaModel;

import java.util.List;
import java.util.Optional;

public interface SalaRepository {
    Optional<SalaModel> buscarPorCodigo(Long id);
    List<SalaModel> buscarTodos();
    void adicionar(SalaModel model);
    void atualizar(SalaModel model);
    void remover(Long id);
}
