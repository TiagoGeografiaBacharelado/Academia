package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.AtividadeInstrutor;
import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import com.example.SmartAcademy.repositories.jpa.AtividadeInstrutorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AtividadeInstrutorMySQLImpl implements com.example.SmartAcademy.interfaces.AtividadeInstrutorRepository {

    private final AtividadeInstrutorJPA atividadeInstrutorJPA;

    @Autowired
    public AtividadeInstrutorMySQLImpl(AtividadeInstrutorJPA atividadeInstrutorJPA) {
        this.atividadeInstrutorJPA = atividadeInstrutorJPA;
    }

    @Override
    public Optional<AtividadeInstrutorModel> buscarPorCodigo(Long id) {
        return atividadeInstrutorJPA.findById(id)
                .map(this::toModel);
    }

    @Override
    public List<AtividadeInstrutorModel> buscarTodos() {
        return atividadeInstrutorJPA.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(AtividadeInstrutorJPA dto) {
        AtividadeInstrutor entity = toEntity(dto);
        entity.setId(null);
        atividadeInstrutorJPA.save(entity);
    }

    @Override
    public void atualizar(AtividadeInstrutorModel dto) {
        AtividadeInstrutor entity = toEntity(dto);
        atividadeInstrutorJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        atividadeInstrutorJPA.deleteById(id);
    }

    @Override
    public Optional<AtividadeInstrutorModel> buscarPorCpf(String cpf) {
        return atividadeInstrutorJPA.findByCpf(cpf)
                .map(this::toModel);
    }

    private AtividadeInstrutorModel toModel(AtividadeInstrutor e) {
        return new AtividadeInstrutorModel(
                e.getId(),
                e.getNome(),
                e.getCpf(),
                e.getEndereco(),
                e.getEmail(),
                e.getTelefone(),
                e.getDataNascimento(),
                e.getObservacaoMedica(),
                e.getAltura(),
                e.getPeso()
        );
    }

    private AtividadeInstrutor toEntity(AtividadeInstrutor dto) {
        return new AtividadeInstrutor(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                dto.getEndereco(),
                dto.getEmail(),
                dto.getTelefone(),
                dto.getDataNascimento(),
                dto.getObservacaoMedica(),
                dto.getAltura(),
                dto.getPeso()
        );
    }
}