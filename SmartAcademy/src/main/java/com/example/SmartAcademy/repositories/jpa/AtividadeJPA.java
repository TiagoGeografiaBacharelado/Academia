package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.AtividadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeJPA extends JpaRepository<AtividadeModel, Integer> {

    List<AtividadeModel> findByAtividade_nome(String atividade_nome);
    List<AtividadeModel> findByDuracao(Integer duracao);
    List<AtividadeModel> findByNomeAtividadeAndDuracao(String nomeAtividade, Integer duracao);
    List<AtividadeModel> findByInstrutorId(Integer instrutorId);
}
