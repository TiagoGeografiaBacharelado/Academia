package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Plano;
import com.example.SmartAcademy.models.PlanoModel;
import com.example.SmartAcademy.repositories.jpa.PlanoJPA;
import com.example.SmartAcademy.interfaces.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PlanoInterfaceMySQLImpl implements PlanoRepository {

    private final PlanoJPA planoJPA;

    @Autowired
    public PlanoInterfaceMySQLImpl(PlanoJPA planoJPA) {
        this.planoJPA = planoJPA;
    }

    @Override
    public Optional<PlanoModel> buscarPorCodigo(Long id) {
        return planoJPA.findById(id)
                .map(this::toModel);
    }

    @Override
    public List<PlanoModel> buscarTodos() {
        return planoJPA.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(PlanoModel dto) {
        Plano entity = toEntity(dto);
        entity.setId(null); // Garante criação
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

    @Override
    public Optional<PlanoModel> buscarPorNome(String nome) {
        return planoJPA.findByNome(nome)
                .map(this::toModel);
    }

    private PlanoModel toModel(Plano e) {
        return new PlanoModel(
                e.getId(),
                e.getNome(),
                e.getPreco(),
                e.getDescricao()
        );
    }

    private Plano toEntity(PlanoModel dto) {
        return new Plano(
                dto.getId(),
                dto.getNome(),
                dto.getPreco(),
                dto.getDescricao()
        );
    }
}
