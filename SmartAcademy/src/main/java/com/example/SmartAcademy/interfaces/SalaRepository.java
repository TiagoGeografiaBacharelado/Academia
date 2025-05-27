package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.SalaModel;
import java.util.List;
import java.util.Optional;

public interface SalaRepository {
    Optional<SalaModel> buscarPorCodigo(Long id);
    List<SalaModel> buscarTodas();
    void adicionar(SalaModel salaModel);
    void atualizar(SalaModel salaModel);
    void remover(Long id);
    Optional<SalaModel> buscarPorNome(String nome);
}
