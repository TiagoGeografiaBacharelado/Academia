package com.example.SmartAcademy.repositories;

import com.example.SmartAcademy.models.FormaPagamentoModels;

import java.util.List;
import java.util.Optional;

public interface FormaPagamentoRepository {
    Optional<FormaPagamentoModels> buscarPorCodigo(Integer id);
    List<FormaPagamentoModels> buscarTodos();
    void adicionar(FormaPagamentoModels formaPagamento);
    void remover(Integer id);
    void atualizar(FormaPagamentoModels formaPagamento);
    Optional<FormaPagamentoModels> buscarPorDescricao(String descricao);
}