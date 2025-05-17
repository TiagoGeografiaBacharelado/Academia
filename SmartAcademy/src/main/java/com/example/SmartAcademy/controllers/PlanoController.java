package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.PlanoModels;
import com.example.SmartAcademy.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    private final PlanoRepository planoRepository;

    @Autowired
    public PlanoController(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    // GET /api/planos
    @GetMapping
    public ResponseEntity<List<PlanoModels>> listarTodos() {
        List<PlanoModels> planos = planoRepository.buscar();
        return ResponseEntity.ok(planos);
    }

    // GET /api/planos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PlanoModels> buscarPorId(@PathVariable Long id) {
        PlanoModels plano = planoRepository.buscarPorCodigo(id);
        if (plano == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(plano);
    }

    // POST /api/planos
    @PostMapping
    public ResponseEntity<PlanoModels> criar(@RequestBody PlanoModels plano) {
        planoRepository.adicionar(plano);
        return ResponseEntity.ok(plano);
    }

    // PUT /api/planos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<PlanoModels> atualizar(@PathVariable Long id,
                                                 @RequestBody PlanoModels plano) {
        PlanoModels existente = planoRepository.buscarPorCodigo(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        plano.setId(id.intValue());  // sincroniza ID
        planoRepository.atualizar(plano);
        return ResponseEntity.ok(plano);
    }

    // DELETE /api/planos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        PlanoModels existente = planoRepository.buscarPorCodigo(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        planoRepository.remover(id);
        return ResponseEntity.noContent().build();
    }
}