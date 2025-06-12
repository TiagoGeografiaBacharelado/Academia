package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.InstrutorTurmaModel;
import com.example.SmartAcademy.services.InstrutorTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instrutorTurmas")
public class InstrutorTurmaController {

    private final InstrutorTurmaService instrutorTurmaService;

    @Autowired
    public InstrutorTurmaController(InstrutorTurmaService instrutorTurmaService) {
        this.instrutorTurmaService = instrutorTurmaService;
    }

    @GetMapping
    public ResponseEntity<List<InstrutorTurmaModel>> listarTodos() {
        return ResponseEntity.ok(instrutorTurmaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorTurmaModel> buscarPorId(@PathVariable Long id) {
        Optional<InstrutorTurmaModel> model = instrutorTurmaService.buscarPorId(id);
        return model.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrutorTurmaModel> criar(@RequestBody InstrutorTurmaModel model) {
        InstrutorTurmaModel criado = instrutorTurmaService.criar(model);
        URI location = URI.create("/api/instrutorTurmas/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrutorTurmaModel> atualizar(@PathVariable Long id, @RequestBody InstrutorTurmaModel model) {
        return ResponseEntity.ok(instrutorTurmaService.atualizar(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        instrutorTurmaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
