package com.example.SmartAcademy.repositories.mysql;

import com.example.SmartAcademy.models.FormaPagamentoModels;
import com.example.SmartAcademy.repositories.FormaPagamentoRepository;
import com.example.SmartAcademy.repositories.jpa.FormaPagamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FormaPagamentoRepositoryMySQLImpl implements FormaPagamentoRepository {

    private final FormaPagamentoJPA formaPagamentoJPA;

    @Autowired
    public FormaPagamentoRepositoryMySQLImpl(FormaPagamentoJPA formaPagamentoJPA) {
        this.formaPagamentoJPA = formaPagamentoJPA;
    }

    @Override
    public Optional<FormaPagamentoModels> buscarPorCodigo(Integer id) {
        return formaPagamentoJPA.findById(id);
    }

    @Override
    public List<FormaPagamentoModels> buscarTodos() {
        return formaPagamentoJPA.findAll();
    }

    @Override
    public void adicionar(FormaPagamentoModels formaPagamento) {
        formaPagamentoJPA.save(formaPagamento);
    }

    @Override
    public void remover(Integer id) {
        formaPagamentoJPA.deleteById(id);
    }

    @Override
    public void atualizar(FormaPagamentoModels formaPagamento) {
        formaPagamentoJPA.save(formaPagamento);
    }

    @Override
    public Optional<FormaPagamentoModels> buscarPorDescricao(String descricao) {
        return formaPagamentoJPA.findByDescricao(descricao);
    }
}