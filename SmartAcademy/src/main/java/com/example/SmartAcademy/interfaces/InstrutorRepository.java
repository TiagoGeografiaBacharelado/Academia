package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.InstrutorModel;
import java.util.List;
import java.util.Optional;

public interface InstrutorRepository {
    Optional<InstrutorModel> buscarPorCodigo(Long id);
    List<InstrutorModel> buscarTodos();
    void adicionar(InstrutorModel instrutorModel);
    void atualizar(InstrutorModel instrutorModel);
    void remover(Long id);
    Optional<InstrutorModel> buscarPorCpf(String cpf);
}
