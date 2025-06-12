package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.AtividadePlanoModel;
import com.example.SmartAcademy.services.AtividadePlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atividade_plano")
public class AtividadePlanoController {

    private final AtividadePlanoService atividadePlanoService;

    @Autowired
    public AtividadePlanoController(AtividadePlanoService atividadePlanoService) {
        this.atividadePlanoService = atividadePlanoService;
    }

    @GetMapping
    public ResponseEntity<List<AtividadePlanoModel>> listarTodos() {
        List<AtividadePlanoModel> lista = atividadePlanoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AtividadePlanoModel>> buscarPorId(@PathVariable int id) {
        Optional<Optional<AtividadePlanoModel>> optional = atividadePlanoService.buscarPorId(id);
        return optional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtividadePlanoModel> criar(@RequestBody AtividadePlanoModel model) {
        AtividadePlanoModel criado = atividadePlanoService.criar(model);
        URI location = URI.create("/api/atividade_plano/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadePlanoModel> atualizar(@PathVariable int id,
                                                         @RequestBody AtividadePlanoModel model) {
        AtividadePlanoModel atualizado = atividadePlanoService.atualizar(id, model);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadePlanoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
