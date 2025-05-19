package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.UsuarioModels;
import com.example.SmartAcademy.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // GET /api/usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioModels>> listarTodos() {
        List<UsuarioModels> usuarios = usuarioRepository.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // GET /api/usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModels> buscarPorId(@PathVariable Long id) {
        UsuarioModels usuario = usuarioRepository.buscarPorCodigo(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    // POST /api/usuarios
    @PostMapping
    public ResponseEntity<UsuarioModels> criar(@RequestBody UsuarioModels usuario) {
        usuarioRepository.adicionar(usuario);
        return ResponseEntity.ok(usuario);
    }

    // PUT /api/usuarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModels> atualizar(@PathVariable Long id,
                                                   @RequestBody UsuarioModels usuario) {
        UsuarioModels existente = usuarioRepository.buscarPorCodigo(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);  // sincroniza ID
        usuarioRepository.atualizar(usuario);
        return ResponseEntity.ok(usuario);
    }

    // DELETE /api/usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        UsuarioModels existente = usuarioRepository.buscarPorCodigo(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.remover(id);
        return ResponseEntity.noContent().build();
    }
}