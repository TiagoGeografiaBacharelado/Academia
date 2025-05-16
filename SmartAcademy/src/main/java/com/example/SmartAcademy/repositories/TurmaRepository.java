package com.example.SmartAcademy.repositories;

import com.example.SmartAcademy.models.TurmaModels;

import java.util.List;

public interface TurmaRepository {
    TurmaModels buscarPorCodigo(int codigo);
    List<TurmaModels> buscar();
    void adicionar(TurmaModels turma);
    void remover(int codigo);
    void atualizar(TurmaModels turma);
}
