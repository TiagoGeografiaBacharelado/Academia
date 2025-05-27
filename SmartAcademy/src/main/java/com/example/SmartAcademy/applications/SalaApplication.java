package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.SalaModel;
import com.example.SmartAcademy.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas/app")
public class SalaApplication {

    private final SalaService salaService;

    @Autowired
    public SalaApplication(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<SalaModel>> listarTodas() {
        return ResponseEntity.ok(salaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaModel> buscarPorId(@PathVariable Long id) {
        return salaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalaModel> criar(@RequestBody SalaModel salaModel) {
        return ResponseEntity.ok(salaService.criar(salaModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaModel> atualizar(@PathVariable Long id, @RequestBody SalaModel salaModel) {
        return ResponseEntity.ok(salaService.atualizar(id, salaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        salaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
