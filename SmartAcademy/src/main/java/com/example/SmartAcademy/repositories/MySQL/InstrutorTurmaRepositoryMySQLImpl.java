package com.example.SmartAcademy.repositories.MySQL;

import com.geriaTeam.geriatricare.interfaces.InstrutorTurmaRepository;
import com.geriaTeam.geriatricare.models.InstrutorTurmaModels;
import com.geriaTeam.geriatricare.repositories.jpa.InstrutorTurmaJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstrutorTurmaRepositoryMySQLImpl implements InstrutorTurmaRepository {

    private final InstrutorTurmaJPA jpa;

    @Autowired
    public InstrutorTurmaRepositoryMySQLImpl(InstrutorTurmaJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public InstrutorTurmaModels buscarPorCodigo(int codigo) {
        return jpa.findById(codigo).orElse(null);
    }

    @Override
    public List<InstrutorTurmaModels> buscar() {
        return jpa.findAll();
    }

    @Override
    public void adicionar(InstrutorTurmaModels instrutorTurma) {
        jpa.save(instrutorTurma);
    }

    @Override
    public void remover(int codigo) {
        jpa.deleteById(codigo);
    }

    @Override
    public void atualizar(InstrutorTurmaModels instrutorTurma) {
        jpa.save(instrutorTurma);
    }
}
