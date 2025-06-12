package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Turma;
import com.example.SmartAcademy.entities.Sala;
import com.example.SmartAcademy.interfaces.TurmaRepository;
import com.example.SmartAcademy.models.TurmaModel;
import com.example.SmartAcademy.repositories.jpa.SalaJPA;
import com.example.SmartAcademy.repositories.jpa.TurmaJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TurmaInterfaceMySQLImpl implements TurmaRepository {

    private final TurmaJPA turmaJPA;
    private final SalaJPA salaJPA;

    @Autowired
    public TurmaInterfaceMySQLImpl(TurmaJPA turmaJPA, SalaJPA salaJPA) {
        this.turmaJPA = turmaJPA;
        this.salaJPA = salaJPA;
    }

    @Override
    public Optional<TurmaModel> buscarPorCodigo(Long id) {
        return turmaJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<TurmaModel> buscarTodos() {
        return turmaJPA.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void adicionar(TurmaModel model) {
        Turma entity = toEntity(model);
        entity.setIdTurma(null);
        turmaJPA.save(entity);
    }

    @Override
    public void atualizar(TurmaModel model) {
        turmaJPA.save(toEntity(model));
    }

    @Override
    public void remover(Long id) {
        turmaJPA.deleteById(id);
    }

    private TurmaModel toModel(Turma entity) {
        return new TurmaModel(entity.getIdTurma(),
                entity.getHorario(),
                entity.getSala().getIdSala()
        );
    }

    private Turma toEntity(TurmaModel model) {
        Sala sala = salaJPA.findById(model.getIdSala()).orElseThrow(
                () -> new IllegalArgumentException("Sala não encontrada com id: " + model.getIdSala())
        );
        return new Turma(model.getIdTurma(), model.getHorario(), sala);
    }
}
