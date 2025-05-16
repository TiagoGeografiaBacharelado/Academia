package com.example.SmartAcademy.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.SmartAcademy.applications.TurmaApplication;
import com.example.SmartAcademy.models.TurmaModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TurmaFacade {

    @Autowired
    private TurmaApplication turmaApplication;

    public List<TurmaModels> buscar() {
        return turmaApplication.buscar();
    }

    public TurmaModels buscarPorCodigo(int codigo) {
        return turmaApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(TurmaModels turmaModels) {
        turmaApplication.adicionar(turmaModels);
    }

    public void atualizar(TurmaModels turmaModels) {
        turmaApplication.atualizar(turmaModels);
    }

    public void remover(int codigo) {
        turmaApplication.remover(codigo);
    }
}
