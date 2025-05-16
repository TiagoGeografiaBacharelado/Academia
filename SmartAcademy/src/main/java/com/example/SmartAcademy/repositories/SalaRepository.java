package com.example.SmartAcademy.repositories;

import com.example.SmartAcademy.models.SalaModels;

import java.util.List;

public interface SalaRepository {
    SalaModels buscarPorCodigo(int codigo);
    List<SalaModels> buscar();
    void adicionar(SalaModels sala);
    void remover(int codigo);
    void atualizar(SalaModels sala);
}
