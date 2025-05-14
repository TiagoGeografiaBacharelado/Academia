package com.geriaTeam.geriatricare.interfaces;

import com.geriaTeam.geriatricare.models.InstrutorTurmaModels;

import java.util.List;

public interface InstrutorTurmaRepository {
    InstrutorTurmaModels buscarPorCodigo(int codigo);
    List<InstrutorTurmaModels> buscar();
    void adicionar(InstrutorTurmaModels instrutorTurma);
    void remover(int codigo);
    void atualizar(InstrutorTurmaModels instrutorTurma);
}
