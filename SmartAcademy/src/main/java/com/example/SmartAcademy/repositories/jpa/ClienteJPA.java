package com.example.SmartAcademy.repositories.jpa; // Pacote JPA

import com.example.SmartAcademy.entities.Cliente; // Importa entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository; // Interface JpaRepository
import org.springframework.stereotype.Repository; // Marca como Repository
import java.util.Optional; // Optional para buscas

@Repository // Sinaliza componente Spring
public interface ClienteJPA extends JpaRepository<Cliente, Long> { // Extende JpaRepository
    Optional<Cliente> findByCpf(String cpf); // Método gerado para buscar por CPF
}