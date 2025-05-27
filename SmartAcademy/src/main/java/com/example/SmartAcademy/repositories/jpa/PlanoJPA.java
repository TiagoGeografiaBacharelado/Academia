package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.PlanoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanoJPA extends JpaRepository<PlanoModels, Integer> {
    List<PlanoModels> findByNome(String nome);
}
