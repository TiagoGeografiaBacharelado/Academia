package com.example.SmartAcademy.repositories;

import com.example.SmartAcademy.models.InstrutorModels;

import java.util.List;

public interface InstrutorRepository {
    InstrutorModels buscarPorCodigo(int codigo);
    List<InstrutorModels> buscar();
    void adicionar(InstrutorModels instrutor);
    void atualizar(InstrutorModels instrutor);
    void remover(int codigo);
}
