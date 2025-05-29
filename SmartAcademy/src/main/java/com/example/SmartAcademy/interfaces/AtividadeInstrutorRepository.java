package com.example.SmartAcademy.interfaces; // Define pacote de interfaces

import com.example.SmartAcademy.models.AtividadeInstrutorModel; // Importa modelo de DTO
import java.util.List; // Importa List genérica
import java.util.Optional; // Importa Optional para resultados opcionais

public interface AtividadeInstrutorRepository { // Define interface ClienteRepository
        Optional<AtividadeInstrutorModel> buscarPorCodigo(int id); // Método para buscar por ID
        List<AtividadeInstrutorModel> buscarTodos(); // Método para listar todos
        void adicionar(AtividadeInstrutorModel atividadeInstrutorModel); // Método para adicionar novo
        void atualizar(AtividadeInstrutorModel atividadeInstrutorModel); // Método para atualizar existente
        void remover(int id); // Método para remover por ID
        Optional<AtividadeInstrutorModel> buscarPorCpf(String cpf);
}
