package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanoJPA extends JpaRepository<Plano, Long> {

    Optional<Plano> findByNome(String nome);
    List<Plano> findByNomeContainingIgnoreCase(String nome);
    List<Plano> findByPrecoLessThanEqual(BigDecimal preco);
    List<Plano> findByPrecoGreaterThanEqual(BigDecimal preco);
    Optional<Plano> findByDescricao(String descricao);
    List<Plano> findByDescricaoContainingIgnoreCase(String descricao);
}
