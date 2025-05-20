package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.PlanoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModels, Integer> {
    List<PlanoModels> findByNome(String nome);
}
