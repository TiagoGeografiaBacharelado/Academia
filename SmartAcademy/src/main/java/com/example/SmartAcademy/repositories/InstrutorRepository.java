package com.geriaTeam.geriatricare.interfaces;

import com.geriaTeam.geriatricare.models.InstrutorModels;
import java.util.List;

public interface InstrutorRepository {
    void adicionar(InstrutorModels instrutor);
    void atualizar(InstrutorModels instrutor);
    void remover(int codigo);
    List<InstrutorModels> buscar();
    InstrutorModels buscarPorCodigo(int codigo);
}
