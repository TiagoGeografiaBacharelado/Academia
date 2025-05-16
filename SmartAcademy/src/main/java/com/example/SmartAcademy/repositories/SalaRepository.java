package com.geriaTeam.geriatricare.interfaces;

import com.geriaTeam.geriatricare.models.SalaModels;

import java.util.List;

public interface SalaRepository {
    SalaModels buscarPorCodigo(int codigo);
    List<SalaModels> buscar();
    void adicionar(SalaModels sala);
    void remover(int codigo);
    void atualizar(SalaModels sala);
}
