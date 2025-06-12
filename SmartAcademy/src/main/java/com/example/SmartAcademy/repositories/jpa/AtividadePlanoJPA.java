package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.AtividadePlano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AtividadePlanoJPA extends JpaRepository<AtividadePlano, Long> {
    Optional<AtividadePlano> findByCpf(String cpf);
}