package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.AtividadePlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadePlanoJPA extends JpaRepository<AtividadePlanoModel, Integer> {

    List<AtividadePlanoModel> findByPlanoId(Integer planoId);
    List<AtividadePlanoModel> findByAtividadeIdAndPlanoId(Integer atividadeId, Integer planoId);
    List<AtividadePlanoModel> findByAtividadeNomeAtividade(String nomeAtividade);
}
