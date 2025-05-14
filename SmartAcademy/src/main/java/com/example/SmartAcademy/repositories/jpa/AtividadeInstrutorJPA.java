package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.AtividadeInstrutorModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeInstrutorJPA extends JpaRepository<AtividadeInstrutorModels, Integer> {

    List<AtividadeInstrutorModels> findByInstrutorId(Integer instrutorId);
    List<AtividadeInstrutorModels> findByNomeAtividade(String nomeAtividade);
    List<AtividadeInstrutorModels> findByNome(Integer instrutorId, String nomeAtividade);
}
