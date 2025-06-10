package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Instrutor;
import com.example.SmartAcademy.interfaces.InstrutorRepository;
import com.example.SmartAcademy.models.InstrutorModel;
import com.example.SmartAcademy.repositories.jpa.InstrutorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InstrutorInterfaceMySQLImpl implements InstrutorRepository {

    private final InstrutorJPA instrutorJPA;

    @Autowired
    public InstrutorInterfaceMySQLImpl(InstrutorJPA instrutorJPA) {
        this.instrutorJPA = instrutorJPA;
    }

    @Override
    public Optional<InstrutorModel> buscarPorCodigo(Long id) {
        return instrutorJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<InstrutorModel> buscarTodos() {
        return instrutorJPA.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void adicionar(InstrutorModel model) {
        Instrutor entity = toEntity(model);
        entity.setIdInstrutor(null);
        instrutorJPA.save(entity);
    }

    @Override
    public void atualizar(InstrutorModel model) {
        instrutorJPA.save(toEntity(model));
    }

    @Override
    public void remover(Long id) {
        instrutorJPA.deleteById(id);
    }

    private InstrutorModel toModel(Instrutor entity) {
        return new InstrutorModel(
                entity.getIdInstrutor(), entity.getNome(), entity.getCpf(),
                entity.getCertificado(), entity.getEmail(), entity.getTelefone(),
                entity.getDataNascimento()
        );
    }

    private Instrutor toEntity(InstrutorModel model) {
        return new Instrutor(
                model.getIdInstrutor(), model.getNome(), model.getCpf(),
                model.getCertificado(), model.getEmail(), model.getTelefone(),
                model.getDataNascimento()
        );
    }
}
