package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import com.example.SmartAcademy.services.AtividadeInstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/atividade-instrutores")
public class AtividadeInstrutorController {

    private final AtividadeInstrutorService atividadeInstrutorService;

    @Autowired
    public AtividadeInstrutorController(AtividadeInstrutorService atividadeInstrutorService) {
        this.atividadeInstrutorService = atividadeInstrutorService;
    }

    @GetMapping
    public ResponseEntity<List<AtividadeInstrutorModel>> listarTodos() {
        return ResponseEntity.ok(atividadeInstrutorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeInstrutorModel> buscarPorId(@PathVariable int id) {
        return atividadeInstrutorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtividadeInstrutorModel> criar(@RequestBody AtividadeInstrutorModel model) {
        AtividadeInstrutorModel criado = atividadeInstrutorService.criar(model);
        URI location = URI.create("/api/atividade-instrutores/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeInstrutorModel> atualizar(@PathVariable int id, @RequestBody AtividadeInstrutorModel model) {
        return ResponseEntity.ok(atividadeInstrutorService.atualizar(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadeInstrutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
