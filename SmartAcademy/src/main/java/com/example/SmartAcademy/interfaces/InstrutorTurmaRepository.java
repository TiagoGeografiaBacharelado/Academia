package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.InstrutorTurmaModel;
import java.util.List;
import java.util.Optional;

public interface InstrutorTurmaRepository {
    Optional<InstrutorTurmaModel> buscarPorIds(Long idInstrutor, Long idTurma);
    List<InstrutorTurmaModel> buscarTodos();
    void adicionar(InstrutorTurmaModel instrutorTurmaModel);
    void atualizar(InstrutorTurmaModel instrutorTurmaModel);
    void remover(Long idInstrutor, Long idTurma);
    List<InstrutorTurmaModel> buscarPorInstrutor(Long idInstrutor);
}
