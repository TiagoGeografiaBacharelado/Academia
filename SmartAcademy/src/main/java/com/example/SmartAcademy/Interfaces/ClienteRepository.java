package com.example.SmartAcademy.interfaces; // Define pacote de interfaces

import com.example.SmartAcademy.models.ClienteModel; // Importa modelo de DTO
import java.util.List; // Importa List genérica
import java.util.Optional; // Importa Optional para resultados opcionais

public interface ClienteRepository { // Define interface ClienteRepository
    Optional<ClienteModel> buscarPorCodigo(Long id); // Método para buscar por ID
    List<ClienteModel> buscarTodos(); // Método para listar todos
    void adicionar(ClienteModel clienteModel); // Método para adicionar novo
    void atualizar(ClienteModel clienteModel); // Método para atualizar existente
    void remover(Long id); // Método para remover por ID
    Optional<ClienteModel> buscarPorCpf(String cpf); // Método para buscar por CPF
}