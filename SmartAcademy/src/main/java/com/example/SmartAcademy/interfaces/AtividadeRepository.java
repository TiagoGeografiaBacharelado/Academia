package com.example.SmartAcademy.interfaces;


import com.example.SmartAcademy.models.AtividadeModel;

import java.util.List;

public interface AtividadeRepository {
    AtividadeModel buscarPorCodigo(int id);
    List<AtividadeModel> buscar();
    void adicionar(AtividadeModel atividadeModel);
    void remover(int id);
    void atualizar(AtividadeModel atividadeModel);
}
