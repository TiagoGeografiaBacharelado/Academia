package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.FormaPagamento;
import com.example.SmartAcademy.models.FormaPagamentoModel;
import com.example.SmartAcademy.repositories.jpa.FormaPagamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FormaPagamentoInterfaceMySQLImpl implements com.example.SmartAcademy.Interfaces.FormaPagamentoRepository {

    private final FormaPagamentoJPA formaPagamentoJPA;

    @Autowired
    public FormaPagamentoInterfaceMySQLImpl(FormaPagamentoJPA formaPagamentoJPA) {
        this.formaPagamentoJPA = formaPagamentoJPA;
    }

    @Override
    public Optional<FormaPagamentoModel> buscarPorCodigo(Long id) {
        return formaPagamentoJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<FormaPagamentoModel> buscarTodos() {
        return formaPagamentoJPA.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void adicionar(FormaPagamentoModel dto) {
        FormaPagamento entity = toEntity(dto);
        entity.setId(null);
        formaPagamentoJPA.save(entity);
    }

    @Override
    public void atualizar(FormaPagamentoModel dto) {
        FormaPagamento entity = toEntity(dto);
        formaPagamentoJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        formaPagamentoJPA.deleteById(id);
    }

    private FormaPagamentoModel toModel(FormaPagamento e) {
        return new FormaPagamentoModel(e.getId(), e.getDescricao());
    }

    private FormaPagamento toEntity(FormaPagamentoModel dto) {
        return new FormaPagamento(dto.getId(), dto.getDescricao());
    }
}