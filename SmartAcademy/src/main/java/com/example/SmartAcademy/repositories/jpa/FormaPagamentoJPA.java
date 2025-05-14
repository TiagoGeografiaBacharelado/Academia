package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.FormaPagamentoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FormaPagamentoJPA extends JpaRepository<FormaPagamentoModels, Integer> {
    Optional<FormaPagamentoModels> findByDescricao(String descricao);
}
