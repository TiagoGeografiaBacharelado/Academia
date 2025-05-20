package com.example.SmartAcademy.interfaces;


import com.example.SmartAcademy.models.AtividadeInstrutorModels;

import java.util.List;

public interface AtividadeInstrutorRepository {

        AtividadeInstrutorModels buscarPorCodigo(int id);
        List<AtividadeInstrutorModels> buscar();
        void adicionar(AtividadeInstrutorModels atividadeInstrutorModels);
        void remover(int id);
        void atualizar(AtividadeInstrutorModels atividadeInstrutorModels);

}
