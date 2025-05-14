package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.ClienteModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteJPA extends JpaRepository<ClienteModels, Integer> {
    Optional<ClienteModels> findByCpf(String cpf);
}
