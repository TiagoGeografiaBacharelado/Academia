package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.ClientePlano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePlanoJPA extends JpaRepository<ClientePlano, Long> {
}