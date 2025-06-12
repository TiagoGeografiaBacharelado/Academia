package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaJPA extends JpaRepository<Sala, Long> {
}
