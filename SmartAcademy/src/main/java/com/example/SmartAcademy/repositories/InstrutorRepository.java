package com.example.SmartAcademy.repositories;

import com.example.SmartAcademy.models.InstrutorModels;
import java.util.List;

public interface InstrutorRepository {
    void adicionar(InstrutorModels instrutor);
    void atualizar(InstrutorModels instrutor);
    void remover(int codigo);
    List<InstrutorModels> buscar();
    InstrutorModels buscarPorCodigo(int codigo);
}
