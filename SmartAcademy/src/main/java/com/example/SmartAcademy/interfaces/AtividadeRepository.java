package com.example.SmartAcademy.interfaces; // Define pacote de interfaces

import com.example.SmartAcademy.models.AtividadeModel; // Importa modelo de DTO
import java.util.List; // Importa List genérica
import java.util.Optional; // Importa Optional para resultados opcionais

public interface AtividadeRepository { // Define interface ClienteRepository
    Optional<AtividadeModel> buscarPorCodigo(int id); // Método para buscar por ID
    List<AtividadeModel> buscarTodos(); // Método para listar todos
    void adicionar(AtividadeModel atividadeModel); // Método para adicionar novo
    void atualizar(AtividadeModel atividadeModel); // Método para atualizar existente
    void remover(int id); // Método para remover por ID
    Optional<AtividadeModel> buscarPorCpf(String cpf); // Método para buscar por CPF
}
