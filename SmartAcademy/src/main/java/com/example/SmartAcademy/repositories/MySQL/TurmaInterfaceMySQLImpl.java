package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Turma;
import com.example.SmartAcademy.models.TurmaModel;
import com.example.SmartAcademy.repositories.jpa.TurmaJPA;
import com.example.SmartAcademy.interfaces.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TurmaInterfaceMySQLImpl implements TurmaRepository {

    private final TurmaJPA turmaJPA;

    @Autowired
    public TurmaInterfaceMySQLImpl(TurmaJPA turmaJPA) {
        this.turmaJPA = turmaJPA;
    }

    @Override
    public Optional<TurmaModel> buscarPorCodigo(Long id) {
        return turmaJPA.findById(id)
                .map(this::toModel);
    }

    @Override
    public List<TurmaModel> buscarTodos() {
        return turmaJPA.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(TurmaModel dto) {
        Turma entity = toEntity(dto);
        entity.setIdTurma(null);
        turmaJPA.save(entity);
    }

    @Override
    public void atualizar(TurmaModel dto) {
        Turma entity = toEntity(dto);
        turmaJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        turmaJPA.deleteById(id);
    }

    private TurmaModel toModel(Turma e) {
        return new TurmaModel(
                e.getIdTurma(),
                e.getHorario(),
                e.getAtividade().getId(), // ou atividadeModel se necessário
                e.getSala().getId()
        );
    }

    private Turma toEntity(TurmaModel dto) {
        Turma turma = new Turma();
        turma.setIdTurma(dto.getId());
        turma.setHorario(dto.getHorario());
        // Relacionamentos devem ser setados por ID ou serviço externo
        return turma;
    }
}
