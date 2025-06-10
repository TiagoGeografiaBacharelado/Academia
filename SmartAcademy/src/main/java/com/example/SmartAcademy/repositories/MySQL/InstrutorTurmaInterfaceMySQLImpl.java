package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Instrutor;
import com.example.SmartAcademy.entities.Turma;
import com.example.SmartAcademy.entities.InstrutorTurma;
import com.example.SmartAcademy.interfaces.InstrutorTurmaRepository;
import com.example.SmartAcademy.models.InstrutorTurmaModel;
import com.example.SmartAcademy.repositories.jpa.InstrutorJPA;
import com.example.SmartAcademy.repositories.jpa.TurmaJPA;
import com.example.SmartAcademy.repositories.jpa.InstrutorTurmaJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InstrutorTurmaInterfaceMySQLImpl implements InstrutorTurmaRepository {

    private final InstrutorTurmaJPA instrutorTurmaJPA;
    private final InstrutorJPA instrutorJPA;
    private final TurmaJPA turmaJPA;

    @Autowired
    public InstrutorTurmaInterfaceMySQLImpl(InstrutorTurmaJPA instrutorTurmaJPA,
                                            InstrutorJPA instrutorJPA,
                                            TurmaJPA turmaJPA) {
        this.instrutorTurmaJPA = instrutorTurmaJPA;
        this.instrutorJPA = instrutorJPA;
        this.turmaJPA = turmaJPA;
    }

    @Override
    public Optional<InstrutorTurmaModel> buscarPorCodigo(Long id) {
        return instrutorTurmaJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<InstrutorTurmaModel> buscarTodos() {
        return instrutorTurmaJPA.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void adicionar(InstrutorTurmaModel model) {
        InstrutorTurma entity = toEntity(model);
        entity.setId(null);
        instrutorTurmaJPA.save(entity);
    }

    @Override
    public void atualizar(InstrutorTurmaModel model) {
        instrutorTurmaJPA.save(toEntity(model));
    }

    @Override
    public void remover(Long id) {
        instrutorTurmaJPA.deleteById(id);
    }

    private InstrutorTurmaModel toModel(InstrutorTurma entity) {
        return new InstrutorTurmaModel(
                entity.getId(),
                entity.getInstrutor().getIdInstrutor(),
                entity.getTurma().getIdTurma()
        );
    }

    private InstrutorTurma toEntity(InstrutorTurmaModel model) {
        Instrutor instrutor = instrutorJPA.findById(model.getIdInstrutor()).orElseThrow(
                () -> new IllegalArgumentException("Instrutor não encontrado com id: " + model.getIdInstrutor())
        );
        Turma turma = turmaJPA.findById(model.getIdTurma()).orElseThrow(
                () -> new IllegalArgumentException("Turma não encontrada com id: " + model.getIdTurma())
        );
        return new InstrutorTurma(model.getId(), instrutor, turma);
    }
}
