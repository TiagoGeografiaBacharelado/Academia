package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import com.example.SmartAcademy.services.AtividadeInstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AtividadeInstrutorApplication {

    private final AtividadeInstrutorService atividadeInstrutorService;

    @Autowired
    public AtividadeInstrutorApplication(AtividadeInstrutorService atividadeInstrutorService) {
        this.atividadeInstrutorService = atividadeInstrutorService;
    }

    public List<AtividadeInstrutorModel> listarTodos() {
        return atividadeInstrutorService.listarTodos();
    }

    public Optional<AtividadeInstrutorModel> buscarPorId(int id) {
        return atividadeInstrutorService.buscarPorId(id);
    }

    public AtividadeInstrutorModel atualizar(int id, AtividadeInstrutorModel model) {
        return atividadeInstrutorService.atualizar(id, model);
    }

    public void deletar(int id) {
        atividadeInstrutorService.deletar(id);
    }

    public AtividadeInstrutorModel criar(AtividadeInstrutorModel model) {
        return atividadeInstrutorService.criar(model);
    }
}
