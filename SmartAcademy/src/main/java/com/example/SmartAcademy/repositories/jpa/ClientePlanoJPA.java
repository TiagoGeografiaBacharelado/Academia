package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.ClientePlanoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientePlanoJPA extends JpaRepository<ClientePlanoModels, Integer> {
    List<ClientePlanoModels> findByClienteId(int clienteId);
}