package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Usuario;
import com.example.SmartAcademy.models.UsuarioModel;
import com.example.SmartAcademy.repositories.jpa.UsuarioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioInterfaceMySQLImpl implements com.example.SmartAcademy.Interfaces.UsuarioRepository {

    private final UsuarioJPA usuarioJPA;

    @Autowired
    public UsuarioInterfaceMySQLImpl(UsuarioJPA usuarioJPA) {
        this.usuarioJPA = usuarioJPA;
    }

    @Override
    public Optional<UsuarioModel> buscarPorCodigo(Long id) {
        return usuarioJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<UsuarioModel> buscarTodos() {
        return usuarioJPA.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(UsuarioModel dto) {
        Usuario entity = toEntity(dto);
        entity.setId(null);
        usuarioJPA.save(entity);
    }

    @Override
    public void atualizar(UsuarioModel dto) {
        Usuario entity = toEntity(dto);
        usuarioJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        usuarioJPA.deleteById(id);
    }

    @Override
    public Optional<UsuarioModel> buscarPorEmail(String email) {
        return usuarioJPA.findByEmail(email).map(this::toModel);
    }

    private UsuarioModel toModel(Usuario e) {
        return new UsuarioModel(e.getId(), e.getNome(), e.getEmail(), e.getSenha());
    }

    private Usuario toEntity(UsuarioModel dto) {
        return new Usuario(dto.getId(), dto.getNome(), dto.getEmail(), dto.getSenha());
    }
}
