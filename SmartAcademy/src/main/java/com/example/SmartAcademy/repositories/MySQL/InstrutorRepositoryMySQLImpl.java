package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.models.InstrutorModels;
import com.example.SmartAcademy.repositories.InstrutorRepository;
import com.example.SmartAcademy.repositories.jpa.InstrutorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstrutorRepositoryMySQLImpl implements InstrutorRepository {

    private final InstrutorJPA jpa;

    @Autowired
    public InstrutorRepositoryMySQLImpl(InstrutorJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public InstrutorModels buscarPorCodigo(int codigo) {
        return jpa.findById(codigo).orElse(null);
    }

    @Override
    public List<InstrutorModels> buscar() {
        return jpa.findAll();
    }

    @Override
    public void adicionar(InstrutorModels instrutor) {
        jpa.save(instrutor);
    }

    @Override
    public void atualizar(InstrutorModels instrutor) {
        jpa.save(instrutor);
    }

    @Override
    public void remover(int codigo) {
        jpa.deleteById(codigo);
    }
}
