package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Instrutor;
import com.example.SmartAcademy.models.InstrutorModel;
import com.example.SmartAcademy.repositories.jpa.InstrutorJPA;
import com.example.SmartAcademy.interfaces.InstrutorRepository;

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
        return instrutorJPA.findById(id)
                .map(this::toModel);
    }

    @Override
    public List<InstrutorModel> buscarTodos() {
        return instrutorJPA.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(InstrutorModel dto) {
        Instrutor entity = toEntity(dto);
        entity.setId(null);
        instrutorJPA.save(entity);
    }

    @Override
    public void atualizar(InstrutorModel dto) {
        Instrutor entity = toEntity(dto);
        instrutorJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        instrutorJPA.deleteById(id);
    }

    @Override
    public Optional<InstrutorModel> buscarPorCpf(String cpf) {
        return Optional.empty();
    }

    private InstrutorModel toModel(Instrutor e) {
        return new InstrutorModel(
                e.getId(),
                e.getNome(),
                e.getCpf(),
                e.getCertificado(),
                e.getEmail(),
                e.getTelefone(),
                e.getDataNascimento(),
                e.getEndereco()
        );
    }

    private Instrutor toEntity(InstrutorModel dto) {
        return new Instrutor(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                dto.getCertificado(),
                dto.getEmail(),
                dto.getTelefone(),
                dto.getDataNascimento(),
                dto.getEndereco()
        );
    }
}