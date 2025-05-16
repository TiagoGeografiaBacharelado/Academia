package com.example.SmartAcademy.repositories.MySQL;

import com.geriaTeam.geriatricare.interfaces.SalaRepository;
import com.geriaTeam.geriatricare.models.SalaModels;
import com.geriaTeam.geriatricare.repositories.jpa.SalaJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaRepositoryMySQLImpl implements SalaRepository {

    private final SalaJPA jpa;

    @Autowired
    public SalaRepositoryMySQLImpl(SalaJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public SalaModels buscarPorCodigo(int codigo) {
        return jpa.findById(codigo).orElse(null);
    }

    @Override
    public List<SalaModels> buscar() {
        return jpa.findAll();
    }

    @Override
    public void adicionar(SalaModels sala) {
        jpa.save(sala);
    }

    @Override
    public void remover(int codigo) {
        jpa.deleteById(codigo);
    }

    @Override
    public void atualizar(SalaModels sala) {
        jpa.save(sala);
    }
}
