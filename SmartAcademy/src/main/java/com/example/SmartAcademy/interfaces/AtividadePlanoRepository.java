package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import com.example.SmartAcademy.models.AtividadePlanoModel;
import java.util.List;
import java.util.Optional;

public interface AtividadePlanoRepository {
    Optional<AtividadePlanoModel> buscarPorCodigo(int id);
    List<AtividadePlanoModel> buscarTodos();
    void adicionar(AtividadePlanoModel atividadePlanoModel);
    void atualizar(AtividadePlanoModel atividadePlanoModel);
    void remover(int id);
    List<AtividadePlanoModel> buscarPorCpf(String cpf);

}
