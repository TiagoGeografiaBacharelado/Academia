package com.example.SmartAcademy.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.SmartAcademy.applications.InstrutorApplication;
import com.example.SmartAcademy.models.InstrutorModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InstrutorFacade {

    @Autowired
    private InstrutorApplication instrutorApplication;

    public List<InstrutorModels> buscar() {
        return instrutorApplication.buscar();
    }

    public InstrutorModels buscarPorCodigo(int codigo) {
        return instrutorApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(InstrutorModels instrutorModels) {
        instrutorApplication.adicionar(instrutorModels);
    }

    public void atualizar(InstrutorModels instrutorModels) {
        instrutorApplication.atualizar(instrutorModels);
    }

    public void remover(int codigo) {
        instrutorApplication.remover(codigo);
    }
}
