package com.example.SmartAcademy.repositories.jpa;

import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeInstrutorJPA extends JpaRepository<AtividadeInstrutorModel, Integer> {

    List<AtividadeInstrutorModel> findByInstrutorId(Integer instrutorId);
    List<AtividadeInstrutorModel> findByNomeAtividade(String nomeAtividade);
    List<AtividadeInstrutorModel> findByNome(Integer instrutorId, String nomeAtividade);
}
