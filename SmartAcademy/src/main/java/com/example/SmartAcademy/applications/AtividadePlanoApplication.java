package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.AtividadePlanoModel;
import com.example.SmartAcademy.services.AtividadePlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atividade_plano/app")
public class AtividadePlanoApplication {

    private final AtividadePlanoService atividadePlanoService;

    @Autowired
    public AtividadePlanoApplication(AtividadePlanoService atividadePlanoService) {
        this.atividadePlanoService = atividadePlanoService;
    }


    @GetMapping
    public ResponseEntity<List<AtividadePlanoModel>> listarTodos() {
        List<AtividadePlanoModel> clientes = atividadePlanoService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AtividadePlanoModel>> buscarPorId(@PathVariable int id) {
        return atividadePlanoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<AtividadePlanoModel> criar(@RequestBody AtividadePlanoModel atividadePlanoModel) {
        AtividadePlanoModel criado = atividadePlanoService.criar(atividadePlanoModel); // CORRETO
        return ResponseEntity.ok(criado);
    }


    // PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AtividadePlanoModel> atualizar(@PathVariable int id,
                                                  @RequestBody AtividadePlanoModel atividadePlanoModel) {
        AtividadePlanoModel atualizado = atividadePlanoService.atualizar(id, atividadePlanoModel);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /api/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadePlanoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}