package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import java.util.List;
import java.util.Optional;

public interface AtividadeInstrutorRepository {
        Optional<AtividadeInstrutorModel> buscarPorCodigo(int id);
        List<AtividadeInstrutorModel> buscarTodos();
        void adicionar(AtividadeInstrutorModel model);
        void atualizar(AtividadeInstrutorModel model);
        void remover(int id);
        Optional<AtividadeInstrutorModel> buscarPorCpf(String cpf);
}
