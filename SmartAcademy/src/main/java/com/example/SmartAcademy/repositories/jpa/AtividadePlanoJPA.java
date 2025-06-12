package com.example.SmartAcademy.repositories.jpa; // Pacote JPA

import com.example.SmartAcademy.entities.AtividadePlano; // Importa entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository; // Interface JpaRepository
import org.springframework.stereotype.Repository; // Marca como Repository
import java.util.Optional; // Optional para buscas

@Repository // Sinaliza componente Spring
public interface AtividadePlanoJPA extends JpaRepository<AtividadePlano, Long> { // Extende JpaRepository
    Optional<AtividadePlano> findByCpf(String cpf); // Método gerado para buscar por CPF
}