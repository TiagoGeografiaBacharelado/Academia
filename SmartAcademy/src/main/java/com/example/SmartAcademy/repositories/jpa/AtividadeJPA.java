package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.Atividade; // Importa entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository; // Interface JpaRepository
import org.springframework.stereotype.Repository; // Marca como Repository
import java.util.Optional; // Optional para buscas

@Repository
public interface AtividadeJPA extends JpaRepository<Atividade, Long> {
    Optional<Atividade> findById(int id);
}