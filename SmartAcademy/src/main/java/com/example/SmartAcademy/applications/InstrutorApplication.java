package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.repositories.InstrutorRepository;
import com.example.SmartAcademy.models.InstrutorModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorApplication {

    private final InstrutorRepository instrutorRepository;

    @Autowired
    public InstrutorApplication(InstrutorRepository instrutorRepository) {
        this.instrutorRepository = instrutorRepository;
    }

    public void adicionar(InstrutorModels instrutor) {
        instrutorRepository.adicionar(instrutor);
    }

    public void atualizar(InstrutorModels instrutor) {
        instrutorRepository.atualizar(instrutor);
    }

    public void remover(int codigo) {
        instrutorRepository.remover(codigo);
    }

    public List<InstrutorModels> buscar() {
        return instrutorRepository.buscar();
    }

    public InstrutorModels buscarPorCodigo(int codigo) {
        return instrutorRepository.buscarPorCodigo(codigo);
    }
}
