package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.UsuarioModel;
import com.example.SmartAcademy.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/app")
public class UsuarioApplication {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioApplication(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        List<UsuarioModel> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> criar(@RequestBody UsuarioModel usuarioModel) {
        UsuarioModel criado = usuarioService.criar(usuarioModel);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizar(@PathVariable Long id,
                                                  @RequestBody UsuarioModel usuarioModel) {
        UsuarioModel atualizado = usuarioService.atualizar(id, usuarioModel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}