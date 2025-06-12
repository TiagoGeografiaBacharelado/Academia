package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorJPA extends JpaRepository<Instrutor, Long> {
}
