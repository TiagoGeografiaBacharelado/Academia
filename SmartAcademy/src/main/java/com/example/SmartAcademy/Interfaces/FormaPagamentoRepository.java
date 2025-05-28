package com.example.SmartAcademy.Interfaces;

import com.example.SmartAcademy.models.FormaPagamentoModel;

import java.util.List;
import java.util.Optional;

public interface FormaPagamentoRepository {
    Optional<FormaPagamentoModel> buscarPorCodigo(Long id);
    List<FormaPagamentoModel> buscarTodos();
    void adicionar(FormaPagamentoModel formaPagamentoModel);
    void atualizar(FormaPagamentoModel formaPagamentoModel);
    void remover(Long id);
}
