package com.example.SmartAcademy.controller;

import com.example.SmartAcademy.models.TurmaModel;
import com.example.SmartAcademy.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<TurmaModel>> listarTodas() {
        return ResponseEntity.ok(turmaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaModel> buscarPorId(@PathVariable Long id) {
        Optional<TurmaModel> optional = turmaService.buscarPorId(id);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TurmaModel> criar(@RequestBody TurmaModel turmaModel) {
        TurmaModel criado = turmaService.criar(turmaModel);
        URI location = URI.create("/api/turmas/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaModel> atualizar(@PathVariable Long id,
                                                @RequestBody TurmaModel turmaModel) {
        TurmaModel atualizado = turmaService.atualizar(id, turmaModel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        turmaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
