package com.example.SmartAcademy.repositories.mysql;

import com.example.SmartAcademy.Interfaces.UsuarioRepository;
import com.example.SmartAcademy.repositories.jpa.UsuarioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.SmartAcademy.models.UsuarioModels;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryMySQLImpl implements UsuarioRepository {

    private final UsuarioJPA usuarioJPA;

    @Autowired
    public UsuarioRepositoryMySQLImpl(UsuarioJPA usuarioJPA) {
        this.usuarioJPA = usuarioJPA;
    }

    @Override
    public UsuarioModels buscarPorCodigo(Long id) {
        return usuarioJPA.findById(id).orElse(null);
    }

    @Override
    public List<UsuarioModels> buscarTodos() {
        return usuarioJPA.findAll();
    }

    @Override
    public void adicionar(com.example.SmartAcademy.models.UsuarioModels u) {
        usuarioJPA.save(u);
    }

    @Override
    public void remover(Long id) {
        usuarioJPA.deleteById(id);
    }

    @Override
    public void atualizar(UsuarioModels u) {
        usuarioJPA.save(u);
    }

    @Override
    public Optional<UsuarioModels> buscarPorEmail(String email) {
        return usuarioJPA.findByEmail(email);
    }
}
