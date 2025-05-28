package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanoJPA extends JpaRepository<PlanoModel, Integer> {
    List<PlanoModel> findByNome(String nome);
}
