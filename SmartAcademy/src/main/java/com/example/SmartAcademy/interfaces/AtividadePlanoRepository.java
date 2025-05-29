package com.example.SmartAcademy.interfaces; // Define pacote de interfaces

import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import com.example.SmartAcademy.models.AtividadePlanoModel; // Importa modelo de DTO
import java.util.List; // Importa List genérica
import java.util.Optional; // Importa Optional para resultados opcionais

public interface AtividadePlanoRepository { // Define interface ClienteRepository
    Optional<AtividadePlanoModel> buscarPorCodigo(int id); // Método para buscar por ID
    List<AtividadePlanoModel> buscarTodos(); // Método para listar todos
    void adicionar(AtividadePlanoModel atividadePlanoModel); // Método para adicionar novo
    void atualizar(AtividadePlanoModel atividadePlanoModel); // Método para atualizar existente
    void remover(int id); // Método para remover por ID
    Optional<AtividadeInstrutorModel> buscarPorCpf(String cpf);
}
