package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.TurmaModel;
import java.util.List;
import java.util.Optional;

public interface TurmaRepository {
    Optional<TurmaModel> buscarPorCodigo(Long id);
    List<TurmaModel> buscarTodas();
    void adicionar(TurmaModel turmaModel);
    void atualizar(TurmaModel turmaModel);
    void remover(Long id);
    List<TurmaModel> buscarPorAtividadeId(Long idAtividade);
}
