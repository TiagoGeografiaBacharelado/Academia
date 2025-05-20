package com.example.SmartAcademy.interfaces;


import com.example.SmartAcademy.models.AtividadePlanoModels;

import java.util.List;

public interface AtividadePLanoRepository {
    AtividadePlanoModels buscarPorCodigo(int id);
    List<AtividadePlanoModels> buscar();
    void adicionar(AtividadePlanoModels atividadePlanoModels);
    void remover(int id);
    void atualizar(AtividadePlanoModels atividadePlanoModels);
}
