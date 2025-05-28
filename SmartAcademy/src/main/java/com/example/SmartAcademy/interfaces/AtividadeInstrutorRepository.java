package com.example.SmartAcademy.interfaces;


import com.example.SmartAcademy.models.AtividadeInstrutorModel;

import java.util.List;

public interface AtividadeInstrutorRepository {

        AtividadeInstrutorModel buscarPorCodigo(int id);
        List<AtividadeInstrutorModel> buscar();
        void adicionar(AtividadeInstrutorModel atividadeInstrutorModel);
        void remover(int id);
        void atualizar(AtividadeInstrutorModel atividadeInstrutorModel);

}
