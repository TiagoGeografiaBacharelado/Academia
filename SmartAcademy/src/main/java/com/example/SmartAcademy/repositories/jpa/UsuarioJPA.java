package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.UsuarioModels;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioJPA extends JpaRepository<UsuarioModels, Long> {
    Optional<UsuarioModels> findByEmail(String email);
}