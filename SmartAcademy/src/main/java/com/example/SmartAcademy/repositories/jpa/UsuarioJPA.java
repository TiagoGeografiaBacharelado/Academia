package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioJPA extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
