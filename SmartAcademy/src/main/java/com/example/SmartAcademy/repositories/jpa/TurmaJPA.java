package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.TurmaModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaJPA extends JpaRepository<TurmaModels, Integer> {
}
