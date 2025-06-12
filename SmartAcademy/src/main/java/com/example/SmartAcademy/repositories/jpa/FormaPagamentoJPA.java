package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoJPA extends JpaRepository<FormaPagamento, Long> {
}