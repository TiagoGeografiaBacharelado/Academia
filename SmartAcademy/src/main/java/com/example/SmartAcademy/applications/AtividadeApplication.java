package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.AtividadeModel;
import com.example.SmartAcademy.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AtividadeApplication {

    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeApplication(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    public List<AtividadeModel> listarTodasAtividades() {
        return atividadeService.listarTodos();
    }

    public Optional<AtividadeModel> buscarAtividadePorId(int id) {
        return atividadeService.buscarPorId(id);
    }

    public AtividadeModel atualizarAtividade(int id, AtividadeModel atividadeModel) {
        return atividadeService.atualizar(id, atividadeModel);
    }

    public void deletarAtividade(int id) {
        atividadeService.deletar(id);
    }

    public AtividadeModel criarAtividade(AtividadeModel atividadeModel) {
        return atividadeService.criar(atividadeModel);
    }
}
