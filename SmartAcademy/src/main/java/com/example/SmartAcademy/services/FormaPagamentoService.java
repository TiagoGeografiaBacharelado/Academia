package com.example.SmartAcademy.services;

import com.example.SmartAcademy.Interfaces.FormaPagamentoRepository;
import com.example.SmartAcademy.models.FormaPagamentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    public FormaPagamentoService(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public List<FormaPagamentoModel> listarTodos() {
        return formaPagamentoRepository.buscarTodos();
    }

    public Optional<FormaPagamentoModel> buscarPorId(Long id) {
        return formaPagamentoRepository.buscarPorCodigo(id);
    }

    public FormaPagamentoModel criar(FormaPagamentoModel dto) {
        formaPagamentoRepository.adicionar(dto);
        return dto;
    }

    public FormaPagamentoModel atualizar(Long id, FormaPagamentoModel dto) {
        Optional<FormaPagamentoModel> existente = formaPagamentoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Forma de pagamento não encontrada com ID: " + id);
        }
        dto.setId(id);
        formaPagamentoRepository.atualizar(dto);
        return dto;
    }

    public void deletar(Long id) {
        Optional<FormaPagamentoModel> existente = formaPagamentoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Forma de pagamento não encontrada com ID: " + id);
        }
        formaPagamentoRepository.remover(id);
    }
}