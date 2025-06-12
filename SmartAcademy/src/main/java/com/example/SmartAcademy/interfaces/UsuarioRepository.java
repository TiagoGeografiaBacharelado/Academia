package com.example.SmartAcademy.interfaces;

import com.example.SmartAcademy.models.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<UsuarioModel> buscarPorCodigo(Long id);
    List<UsuarioModel> buscarTodos();
    void adicionar(UsuarioModel usuarioModel);
    void atualizar(UsuarioModel usuarioModel);
    void remover(Long id);
    Optional<UsuarioModel> buscarPorEmail(String email);
}