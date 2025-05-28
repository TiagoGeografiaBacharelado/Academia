package com.example.SmartAcademy.services;

import com.example.SmartAcademy.Interfaces.UsuarioRepository;
import com.example.SmartAcademy.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> listarTodos() {
        return usuarioRepository.buscarTodos();
    }

    public Optional<UsuarioModel> buscarPorId(Long id) {
        return usuarioRepository.buscarPorCodigo(id);
    }

    public UsuarioModel criar(UsuarioModel dto) {
        if (usuarioRepository.buscarPorEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }
        usuarioRepository.adicionar(dto);
        return dto;
    }

    public UsuarioModel atualizar(Long id, UsuarioModel dto) {
        Optional<UsuarioModel> existente = usuarioRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + id);
        }
        dto.setId(id);
        usuarioRepository.atualizar(dto);
        return dto;
    }

    public void deletar(Long id) {
        Optional<UsuarioModel> existente = usuarioRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.remover(id);
    }
}