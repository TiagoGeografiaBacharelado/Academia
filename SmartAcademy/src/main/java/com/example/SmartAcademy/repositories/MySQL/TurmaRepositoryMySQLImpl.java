package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.models.TurmaModels;
import com.example.SmartAcademy.repositories.TurmaRepository;
import com.example.SmartAcademy.repositories.jpa.TurmaJPA;
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
