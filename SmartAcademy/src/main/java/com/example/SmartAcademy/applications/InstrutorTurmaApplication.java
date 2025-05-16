package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.interfaces.InstrutorTurmaRepository;
import com.geriaTeam.geriatricare.models.InstrutorTurmaModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorTurmaApplication {

    private final InstrutorTurmaRepository instrutorTurmaRepository;

    @Autowired
    public InstrutorTurmaApplication(InstrutorTurmaRepository instrutorTurmaRepository) {
        this.instrutorTurmaRepository = instrutorTurmaRepository;
    }

    public void adicionar(InstrutorTurmaModels instrutorTurma) {
        instrutorTurmaRepository.adicionar(instrutorTurma);
    }

    public void atualizar(InstrutorTurmaModels instrutorTurma) {
        instrutorTurmaRepository.atualizar(instrutorTurma);
    }

    public void remover(int codigo) {
        instrutorTurmaRepository.remover(codigo);
    }

    public List<InstrutorTurmaModels> buscar() {
        return instrutorTurmaRepository.buscar();
    }

    public InstrutorTurmaModels buscarPorCodigo(int codigo) {
        return instrutorTurmaRepository.buscarPorCodigo(codigo);
    }
}
