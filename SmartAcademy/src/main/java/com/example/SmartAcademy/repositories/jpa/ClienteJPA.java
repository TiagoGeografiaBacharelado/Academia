package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.Cliente; // Importa entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository; // Interface JpaRepository
import org.springframework.stereotype.Repository; // Marca como Repository
import java.util.Optional; // Optional para buscas

@Repository
public interface ClienteJPA extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
}