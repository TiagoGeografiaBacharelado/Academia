package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.AtividadeInstrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtividadeInstrutorJPA extends JpaRepository<AtividadeInstrutor, Long> {
    Optional<AtividadeInstrutor> findByInstrutorCpf(String cpf);
}
