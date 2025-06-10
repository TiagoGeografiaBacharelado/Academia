package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.InstrutorTurmaModel;
import com.example.SmartAcademy.services.InstrutorTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutorTurmas/app")
public class InstrutorTurmaApplication {

    private final InstrutorTurmaService instrutorTurmaService;

    @Autowired
    public InstrutorTurmaApplication(InstrutorTurmaService instrutorTurmaService) {
        this.instrutorTurmaService = instrutorTurmaService;
    }

    @GetMapping
    public ResponseEntity<List<InstrutorTurmaModel>> listarTodos() {
        return ResponseEntity.ok(instrutorTurmaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorTurmaModel> buscarPorId(@PathVariable Long id) {
        return instrutorTurmaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrutorTurmaModel> criar(@RequestBody InstrutorTurmaModel model) {
        return ResponseEntity.ok(instrutorTurmaService.criar(model));
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
