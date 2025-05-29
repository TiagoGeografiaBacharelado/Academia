package com.example.SmartAcademy.controller;

import com.example.SmartAcademy.models.SalaModel;
import com.example.SmartAcademy.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<SalaModel>> listarTodas() {
        return ResponseEntity.ok(salaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaModel> buscarPorId(@PathVariable Long id) {
        Optional<SalaModel> optional = salaService.buscarPorId(id);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalaModel> criar(@RequestBody SalaModel salaModel) {
        SalaModel criado = salaService.criar(salaModel);
        URI location = URI.create("/api/salas/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaModel> atualizar(@PathVariable Long id,
                                               @RequestBody SalaModel salaModel) {
        SalaModel atualizado = salaService.atualizar(id, salaModel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        salaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
