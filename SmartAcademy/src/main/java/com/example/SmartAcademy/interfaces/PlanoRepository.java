package com.example.SmartAcademy.interfaces; // Define pacote de interfaces

import com.example.SmartAcademy.models.PlanoModel; // Importa modelo de DTO
import java.util.List; // Importa List genérica
import java.util.Optional; // Importa Optional para resultados opcionais

public interface PlanoRepository { // Define interface ClienteRepository
    Optional<PlanoModel> buscarPorCodigo(int id); // Método para buscar por ID
    List<PlanoModel> buscarTodos(); // Método para listar todos
    void adicionar(PlanoModel planoModel); // Método para adicionar novo
    void atualizar(PlanoModel planoModel); // Método para atualizar existente
    void remover(int id); // Método para remover por ID
    Optional<PlanoModel> buscarPorCpf(String cpf); // Método para buscar por CPF
}
