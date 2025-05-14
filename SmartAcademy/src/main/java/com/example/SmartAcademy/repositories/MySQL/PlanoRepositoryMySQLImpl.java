package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.interfaces.PlanoRepository;
import com.example.SmartAcademy.models.Plano;
import com.example.SmartAcademy.repositories.jpa.PlanoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanoRepositoryMySQLImpl implements PlanoRepository {

    private final PlanoJPA planoJPA;

    @Autowired
    public PlanoRepositoryMySQLImpl(PlanoJPA planoJPA) {
        this.planoJPA = planoJPA;
    }

    @Override
    public Plano buscarPorCodigo(Long id) {
        return planoJPA.findById(id).orElse(null);
    }

    @Override
    public List<Plano> buscar() {
        return planoJPA.findAll();
    }

    @Override
    public void adicionar(Plano plano) {
        planoJPA.save(plano);
    }

    @Override
    public void remover(Long id) {
        planoJPA.deleteById(id);
    }

    @Override
    public void atualizar(Plano plano) {
        planoJPA.save(plano);
    }

    @Override
    public List<Plano> buscarPorNome(String nome) {
        return planoJPA.findByNome(nome);
    }
}
