package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaJPA extends JpaRepository<Turma, Long> {
}
