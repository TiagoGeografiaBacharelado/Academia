package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.AtividadePlanoModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadePlanoJPA extends JpaRepository<AtividadePlanoModels, Integer> {

    List<AtividadePlanoModels> findByPlanoId(Integer planoId);
    List<AtividadePlanoModels> findByAtividadeIdAndPlanoId(Integer atividadeId, Integer planoId);
    List<AtividadePlanoModels> findByAtividadeNomeAtividade(String nomeAtividade);
}
