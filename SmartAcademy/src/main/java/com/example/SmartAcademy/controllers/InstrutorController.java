package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.InstrutorModel;
import com.example.SmartAcademy.services.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instrutores")
public class InstrutorController {

    private final InstrutorService instrutorService;

    @Autowired
    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @GetMapping
    public ResponseEntity<List<InstrutorModel>> listarTodos() {
        return ResponseEntity.ok(instrutorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorModel> buscarPorId(@PathVariable Long id) {
        Optional<InstrutorModel> instrutor = instrutorService.buscarPorId(id);
        return instrutor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrutorModel> criar(@RequestBody InstrutorModel model) {
        InstrutorModel criado = instrutorService.criar(model);
        URI location = URI.create("/api/instrutores/" + criado.getIdInstrutor());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrutorModel> atualizar(@PathVariable Long id, @RequestBody InstrutorModel model) {
        return ResponseEntity.ok(instrutorService.atualizar(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        instrutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
