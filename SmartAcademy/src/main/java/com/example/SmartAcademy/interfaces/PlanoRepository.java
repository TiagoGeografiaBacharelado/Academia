package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.PlanoModel;

import java.util.List;

public interface PlanoRepository {
    void adicionar(PlanoModel plano);
    void atualizar(PlanoModel plano);
    void remover(int codigo);
    List<PlanoModel> buscar();
    PlanoModel buscarPorCodigo(int codigo);
    List<PlanoModel> buscarPorNome(String nome);
}
