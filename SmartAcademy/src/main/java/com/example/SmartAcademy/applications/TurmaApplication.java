package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.TurmaModel;
import com.example.SmartAcademy.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas/app")
public class TurmaApplication {

    private final TurmaService turmaService;

    @Autowired
    public TurmaApplication(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<TurmaModel>> listarTodas() {
        return ResponseEntity.ok(turmaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaModel> buscarPorId(@PathVariable Long id) {
        return turmaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TurmaModel> criar(@RequestBody TurmaModel turmaModel) {
        return ResponseEntity.ok(turmaService.criar(turmaModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaModel> atualizar(@PathVariable Long id, @RequestBody TurmaModel turmaModel) {
        return ResponseEntity.ok(turmaService.atualizar(id, turmaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        turmaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
