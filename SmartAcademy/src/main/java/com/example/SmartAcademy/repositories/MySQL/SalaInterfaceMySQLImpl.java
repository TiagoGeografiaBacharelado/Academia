package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Sala;
import com.example.SmartAcademy.interfaces.SalaRepository;
import com.example.SmartAcademy.models.SalaModel;
import com.example.SmartAcademy.repositories.jpa.SalaJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SalaInterfaceMySQLImpl implements SalaRepository {

    private final SalaJPA salaJPA;

    @Autowired
    public SalaInterfaceMySQLImpl(SalaJPA salaJPA) {
        this.salaJPA = salaJPA;
    }

    @Override
    public Optional<SalaModel> buscarPorCodigo(Long id) {
        return salaJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<SalaModel> buscarTodos() {
        return salaJPA.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void adicionar(SalaModel model) {
        Sala entity = toEntity(model);
        entity.setIdSala(null);
        salaJPA.save(entity);
    }

    @Override
    public void atualizar(SalaModel model) {
        salaJPA.save(toEntity(model));
    }

    @Override
    public void remover(Long id) {
        salaJPA.deleteById(id);
    }

    private SalaModel toModel(Sala entity) {
        return new SalaModel(entity.getIdSala(),
                entity.getNome(),
                entity.getCapacidade()
        );
    }

    private Sala toEntity(SalaModel model) {
        return new Sala(model.getIdSala(),
                model.getNome(),
                model.getCapacidade()
        );
    }
}