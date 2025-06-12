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

    // Lista planos que contenham parte do nome (ignora maiúsculas/minúsculas)
    List<Plano> findByNomeContainingIgnoreCase(String nome);

    // Busca planos com preço igual ou menor que o valor informado
    List<Plano> findByPrecoLessThanEqual(BigDecimal preco);

    // Busca planos com preço igual ou maior que o valor informado
    List<Plano> findByPrecoGreaterThanEqual(BigDecimal preco);

    // Busca por descrição exata
    Optional<Plano> findByDescricao(String descricao);

    // Lista planos que contenham um trecho na descrição (ignora maiúsculas/minúsculas)
    List<Plano> findByDescricaoContainingIgnoreCase(String descricao);
}
