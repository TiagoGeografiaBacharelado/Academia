package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.InstrutorTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorTurmaJPA extends JpaRepository<InstrutorTurma, Long> {
}
