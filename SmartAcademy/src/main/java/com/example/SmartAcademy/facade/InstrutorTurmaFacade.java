package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.InstrutorTurmaApplication;
import com.geriaTeam.geriatricare.models.InstrutorTurmaModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InstrutorTurmaFacade {

    @Autowired
    private InstrutorTurmaApplication instrutorTurmaApplication;

    public List<InstrutorTurmaModels> buscar() {
        return instrutorTurmaApplication.buscar();
    }

    public InstrutorTurmaModels buscarPorCodigo(int codigo) {
        return instrutorTurmaApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(InstrutorTurmaModels instrutorTurmaModels) {
        instrutorTurmaApplication.adicionar(instrutorTurmaModels);
    }

    public void atualizar(InstrutorTurmaModels instrutorTurmaModels) {
        instrutorTurmaApplication.atualizar(instrutorTurmaModels);
    }

    public void remover(int codigo) {
        instrutorTurmaApplication.remover(codigo);
    }
}
