package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.SalaApplication;
import com.geriaTeam.geriatricare.models.SalaModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SalaFacade {

    @Autowired
    private SalaApplication salaApplication;

    public List<SalaModels> buscar() {
        return salaApplication.buscar();
    }

    public SalaModels buscarPorCodigo(int codigo) {
        return salaApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(SalaModels salaModels) {
        salaApplication.adicionar(salaModels);
    }

    public void atualizar(SalaModels salaModels) {
        salaApplication.atualizar(salaModels);
    }

    public void remover(int codigo) {
        salaApplication.remover(codigo);
    }
}
