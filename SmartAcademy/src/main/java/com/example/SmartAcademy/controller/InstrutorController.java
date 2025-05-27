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
        Optional<InstrutorModel> optional = instrutorService.buscarPorId(id);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrutorModel> criar(@RequestBody InstrutorModel instrutorModel) {
        InstrutorModel criado = instrutorService.criar(instrutorModel);
        URI location = URI.create("/api/instrutores/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrutorModel> atualizar(@PathVariable Long id,
                                                    @RequestBody InstrutorModel instrutorModel) {
        InstrutorModel atualizado = instrutorService.atualizar(id, instrutorModel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        instrutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
