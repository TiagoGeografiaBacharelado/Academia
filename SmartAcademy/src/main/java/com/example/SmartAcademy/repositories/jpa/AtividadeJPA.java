package com.example.SmartAcademy.repositories.jpa; // Pacote JPA

import com.example.SmartAcademy.entities.Atividade; // Importa entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository; // Interface JpaRepository
import org.springframework.stereotype.Repository; // Marca como Repository
import java.util.Optional; // Optional para buscas

@Repository // Sinaliza componente Spring
public interface AtividadeJPA extends JpaRepository<Atividade, Long> { // Extende JpaRepository
    Optional<Atividade> findById(int id); // Método gerado para buscar por CPF
}