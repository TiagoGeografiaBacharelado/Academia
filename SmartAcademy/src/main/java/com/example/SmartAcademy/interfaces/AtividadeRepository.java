package com.example.SmartAcademy.interfaces;


import com.example.SmartAcademy.models.AtividadeModels;

import java.util.List;

public interface AtividadeRepository {
    AtividadeModels buscarPorCodigo(int id);
    List<AtividadeModels> buscar();
    void adicionar(AtividadeModels atividadeModels);
    void remover(int id);
    void atualizar(AtividadeModels atividadeModels);
}
