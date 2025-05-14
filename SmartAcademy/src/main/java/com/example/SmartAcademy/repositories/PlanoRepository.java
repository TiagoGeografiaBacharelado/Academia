package com.example.SmartAcademy.repositories;

import com.example.SmartAcademy.models.PlanoModels;
import java.util.List;

public interface PlanoRepository {
    PlanoModels buscarPorCodigo(Long id);
    List<PlanoModels> buscar();
    void adicionar(PlanoModels plano);
    void remover(Long id);
    void atualizar(PlanoModels plano);
}
