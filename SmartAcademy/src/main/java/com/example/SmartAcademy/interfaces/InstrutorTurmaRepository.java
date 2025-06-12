package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.InstrutorTurmaModel;
import java.util.List;
import java.util.Optional;

public interface InstrutorTurmaRepository {
    Optional<InstrutorTurmaModel> buscarPorCodigo(Long id);
    List<InstrutorTurmaModel> buscarTodos();
    void adicionar(InstrutorTurmaModel model);
    void atualizar(InstrutorTurmaModel model);
    void remover(Long id);
}