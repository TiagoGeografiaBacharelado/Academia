package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.AtividadeModel;
import com.example.SmartAcademy.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Atividades/app")
public class AtividadeApplication {

    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeApplication(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    // GET /api/clientes
    @GetMapping
    public ResponseEntity<List<AtividadeModel>> listarTodos() {
        List<AtividadeModel> atividades = atividadeService.listarTodos();
        return ResponseEntity.ok(atividades);
    }

    // GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AtividadeModel>> buscarPorId(@PathVariable int id) {
        return atividadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AtividadeModel> atualizar(@PathVariable int id,
                                                  @RequestBody AtividadeModel atividadeModel) {
        AtividadeModel atualizado = atividadeService.atualizar(id, atividadeModel);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /api/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}