package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.InstrutorTurma;
import com.example.SmartAcademy.models.InstrutorTurmaModel;
import com.example.SmartAcademy.repositories.jpa.InstrutorTurmaJPA;
import com.example.SmartAcademy.interfaces.InstrutorTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InstrutorTurmaInterfaceMySQLImpl implements InstrutorTurmaRepository {

    private final InstrutorTurmaJPA instrutorTurmaJPA;

    @Autowired
    public InstrutorTurmaInterfaceMySQLImpl(InstrutorTurmaJPA instrutorTurmaJPA) {
        this.instrutorTurmaJPA = instrutorTurmaJPA;
    }

    @Override
    public Optional<InstrutorTurmaModel> buscarPorCodigo(Long id) {
        return instrutorTurmaJPA.findById(id)
                .map(this::toModel);
    }

    @Override
    public List<InstrutorTurmaModel> buscarTodos() {
        return instrutorTurmaJPA.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(InstrutorTurmaModel dto) {
        InstrutorTurma entity = toEntity(dto);
        entity.setId(null);
        instrutorTurmaJPA.save(entity);
    }

    @Override
    public void atualizar(InstrutorTurmaModel dto) {
        InstrutorTurma entity = toEntity(dto);
        instrutorTurmaJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        instrutorTurmaJPA.deleteById(id);
    }

    private InstrutorTurmaModel toModel(InstrutorTurma e) {
        return new InstrutorTurmaModel(
                e.getId(),
                e.getInstrutor().getId(),
                e.getTurma().getIdTurma(),
                e.getClienteId()
        );
    }

    private InstrutorTurma toEntity(InstrutorTurmaModel dto) {
        InstrutorTurma entity = new InstrutorTurma();
        entity.setId(dto.getId());
        // Relacionamentos devem ser carregados fora ou em serviço
        entity.setClienteId(dto.getClienteId());
        return entity;
    }
}
