
package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.PlanoModel;
import com.example.SmartAcademy.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos/app")
public class PlanoApplication {

    private final PlanoService planoService;

    @Autowired
    public PlanoApplication(PlanoService planoService) {
        this.planoService = planoService;
    }

    // GET /api/clientes
    @GetMapping
    public ResponseEntity<List<PlanoModel>> listarTodos() {
        List<PlanoModel> planos = planoService.listarTodos();
        return ResponseEntity.ok(planos);
    }

    // GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PlanoModel> buscarPorId(@PathVariable Long id) {
        return planoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/clientes
    @PostMapping
    public ResponseEntity<PlanoModel> criar(@RequestBody PlanoModel planoModel) {
        PlanoModel criado = planoService.criar(planoModel);
        return ResponseEntity.ok(criado);
    }

    // PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<PlanoModel> atualizar(@PathVariable Long id,
                                                @RequestBody PlanoModel planoModel) {
        PlanoModel atualizado = planoService.atualizar(id, planoModel);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /api/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        planoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

