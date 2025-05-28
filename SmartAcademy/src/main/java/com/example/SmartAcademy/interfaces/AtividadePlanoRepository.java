package com.example.SmartAcademy.interfaces;


import com.example.SmartAcademy.models.AtividadePlanoModel;

import java.util.List;

public interface AtividadePlanoRepository {
    AtividadePlanoModel buscarPorCodigo(int id);
    List<AtividadePlanoModel> buscar();
    void adicionar(AtividadePlanoModel atividadePlanoModel);
    void remover(int id);
    void atualizar(AtividadePlanoModel atividadePlanoModel);
}
