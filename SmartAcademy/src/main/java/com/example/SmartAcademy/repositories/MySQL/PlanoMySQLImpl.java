package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Plano;
import com.example.SmartAcademy.models.PlanoModel;
import com.example.SmartAcademy.repositories.jpa.PlanoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PlanoMySQLImpl implements com.example.SmartAcademy.Interfaces.PlanoRepository {

    private final PlanoJPA planoJPA;

    @Autowired
    public PlanoMySQLImpl(PlanoJPA planoJPA) {
        this.planoJPA = planoJPA;
    }

    @Override
    public Optional<PlanoModel> buscarPorCodigo(long id) {
        return planoJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<PlanoModel> buscarTodos() {
        return PlanoJPA.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void adicionar(PlanoModel dto) {
        Plano entity = toEntity(dto);
        entity.setId(null);
        planoJPA.save(entity);
    }

    @Override
    public void atualizar(PlanoModel dto) {
        Plano entity = toEntity(dto);
        planoJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        planoJPA.deleteById(id);
    }

    private PlanoModel toModel(Plano e) {
        return new PlanoModel(e.getId(), e.getDescricao());
    }

    private Plano toEntity(PlanoModel dto) {
        return new Plano(dto.getId(), dto.getDescricao());
    }
}