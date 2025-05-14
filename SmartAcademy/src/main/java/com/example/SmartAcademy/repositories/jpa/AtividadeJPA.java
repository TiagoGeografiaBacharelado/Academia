package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.AtividadeModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeJPA extends JpaRepository<AtividadeModels, Integer> {

    List<AtividadeModels> findByAtividade_nome(String atividade_nome);
    List<AtividadeModels> findByDuracao(Integer duracao);
    List<AtividadeModels> findByNomeAtividadeAndDuracao(String nomeAtividade, Integer duracao);
    List<AtividadeModels> findByInstrutorId(Integer instrutorId);
}
