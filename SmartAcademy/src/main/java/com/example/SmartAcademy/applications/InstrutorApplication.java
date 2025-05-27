package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.InstrutorModel;
import com.example.SmartAcademy.services.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutores/app")
public class InstrutorApplication {

    private final InstrutorService instrutorService;

    @Autowired
    public InstrutorApplication(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @GetMapping
    public ResponseEntity<List<InstrutorModel>> listarTodos() {
        return ResponseEntity.ok(instrutorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorModel> buscarPorId(@PathVariable Long id) {
        return instrutorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrutorModel> criar(@RequestBody InstrutorModel instrutorModel) {
        return ResponseEntity.ok(instrutorService.criar(instrutorModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrutorModel> atualizar(@PathVariable Long id, @RequestBody InstrutorModel instrutorModel) {
        return ResponseEntity.ok(instrutorService.atualizar(id, instrutorModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        instrutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
