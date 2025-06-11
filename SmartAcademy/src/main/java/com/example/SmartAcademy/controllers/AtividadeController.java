package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.AtividadeModel;
import com.example.SmartAcademy.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public ResponseEntity<List<AtividadeModel>> listarTodos() {
        return ResponseEntity.ok(atividadeService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeModel> buscarPorId(@PathVariable int id) {
        return atividadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtividadeModel> criar(@RequestBody AtividadeModel atividadeModel) {
        AtividadeModel criado = atividadeService.criar(atividadeModel);
        URI location = URI.create("/api/atividades/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeModel> atualizar(@PathVariable int id, @RequestBody AtividadeModel atividadeModel) {
        return ResponseEntity.ok(atividadeService.atualizar(id, atividadeModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}