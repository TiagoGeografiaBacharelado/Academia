package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.PlanoModels;

import java.util.List;

public interface PlanoRepository {
    void adicionar(PlanoModels plano);
    void atualizar(PlanoModels plano);
    void remover(int codigo);
    List<PlanoModels> buscar();
    PlanoModels buscarPorCodigo(int codigo);
    List<PlanoModels> buscarPorNome(String nome);
}
