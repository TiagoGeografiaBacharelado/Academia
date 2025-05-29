package com.example.SmartAcademy.repositories.jpa; // Pacote JPA

import com.example.SmartAcademy.entities.AtividadeInstrutor; // Importa entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository; // Interface JpaRepository
import org.springframework.stereotype.Repository; // Marca como Repository
import java.util.Optional; // Optional para buscas

@Repository // Sinaliza componente Spring
public interface AtividadeInstrutorJPA extends JpaRepository<AtividadeInstrutor, Long> { // Extende JpaRepository
    Optional<AtividadeInstrutor> findByCpf(String cpf);
}