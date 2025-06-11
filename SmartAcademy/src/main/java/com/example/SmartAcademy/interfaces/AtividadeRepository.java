package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.AtividadeModel;
import java.util.List;
import java.util.Optional;

public interface AtividadeRepository {
    Optional<AtividadeModel> buscarPorCodigo(int id);
    List<AtividadeModel> buscarTodos();
    void adicionar(AtividadeModel atividadeModel);
    void atualizar(AtividadeModel atividadeModel);
    void remover(int id);
    Optional<AtividadeModel> buscarPorCpf(String cpf);
}