package com.geriaTeam.geriatricare.interfaces;

import com.geriaTeam.geriatricare.models.TurmaModels;

import java.util.List;

public interface TurmaRepository {
    TurmaModels buscarPorCodigo(int codigo);
    List<TurmaModels> buscar();
    void adicionar(TurmaModels turma);
    void remover(int codigo);
    void atualizar(TurmaModels turma);
}
