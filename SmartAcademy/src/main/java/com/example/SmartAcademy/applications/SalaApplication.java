package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.SalaModel;
import com.example.SmartAcademy.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salas/app")
public class SalaApplication {

    private final SalaService salaService;

    @Autowired
    public SalaApplication(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<SalaModel>> listarTodos() {
        return ResponseEntity.ok(salaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaModel> buscarPorId(@PathVariable Long id) {
        Optional<SalaModel> sala = salaService.buscarPorId(id);
        return sala.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalaModel> criar(@RequestBody SalaModel model) {
        SalaModel criado = salaService.criar(model);
        URI location = URI.create("/api/salas/app/" + criado.getIdSala());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaModel> atualizar(@PathVariable Long id, @RequestBody SalaModel model) {
        return ResponseEntity.ok(salaService.atualizar(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        salaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}