package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.repositories.TurmaRepository;
import com.example.SmartAcademy.models.TurmaModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaApplication {

    private final TurmaRepository turmaRepository;

    @Autowired
    public TurmaApplication(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public void adicionar(TurmaModels turma) {
        turmaRepository.adicionar(turma);
    }

    public void atualizar(TurmaModels turma) {
        turmaRepository.atualizar(turma);
    }

    public void remover(int codigo) {
        turmaRepository.remover(codigo);
    }

    public List<TurmaModels> buscar() {
        return turmaRepository.buscar();
    }

    public TurmaModels buscarPorCodigo(int codigo) {
        return turmaRepository.buscarPorCodigo(codigo);
    }
}
