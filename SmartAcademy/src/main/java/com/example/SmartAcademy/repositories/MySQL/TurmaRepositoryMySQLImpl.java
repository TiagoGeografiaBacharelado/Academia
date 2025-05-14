package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.interfaces.TurmaRepository;
import com.geriaTeam.geriatricare.models.TurmaModels;
import com.geriaTeam.geriatricare.repositories.jpa.TurmaJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaRepositoryMySQLImpl implements TurmaRepository {

    private final TurmaJPA jpa;

    @Autowired
    public TurmaRepositoryMySQLImpl(TurmaJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public TurmaModels buscarPorCodigo(int codigo) {
        return jpa.findById(codigo).orElse(null);
    }

    @Override
    public List<TurmaModels> buscar() {
        return jpa.findAll();
    }

    @Override
    public void adicionar(TurmaModels turma) {
        jpa.save(turma);
    }

    @Override
    public void remover(int codigo) {
        jpa.deleteById(codigo);
    }

    @Override
    public void atualizar(TurmaModels turma) {
        jpa.save(turma);
    }
}
