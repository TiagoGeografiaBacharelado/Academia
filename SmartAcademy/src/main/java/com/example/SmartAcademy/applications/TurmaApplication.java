package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.TurmaModel;
import com.example.SmartAcademy.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas/app")
public class TurmaApplication {

    private final TurmaService turmaService;

    @Autowired
    public TurmaApplication(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<TurmaModel>> listarTodos() {
        return ResponseEntity.ok(turmaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaModel> buscarPorId(@PathVariable Long id) {
        Optional<TurmaModel> turma = turmaService.buscarPorId(id);
        return turma.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TurmaModel> criar(@RequestBody TurmaModel model) {
        TurmaModel criado = turmaService.criar(model);
        URI location = URI.create("/api/turmas/app/" + criado.getIdTurma());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaModel> atualizar(@PathVariable Long id, @RequestBody TurmaModel model) {
        return ResponseEntity.ok(turmaService.atualizar(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        turmaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}