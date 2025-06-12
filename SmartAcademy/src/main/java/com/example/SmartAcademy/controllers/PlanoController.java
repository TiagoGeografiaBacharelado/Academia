package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.PlanoModel;
import com.example.SmartAcademy.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    private final PlanoService planoService;

    @Autowired
    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public ResponseEntity<List<PlanoModel>> listarTodos() {
        List<PlanoModel> lista = planoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoModel> buscarPorId(@PathVariable int id) {
        Optional<PlanoModel> optional = planoService.buscarPorId(id);
        return optional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlanoModel> criar(@RequestBody PlanoModel planoModel) {
        PlanoModel criado = planoService.criar(planoModel);
        URI location = URI.create("/api/planos/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoModel> atualizar(@PathVariable int id,
                                                  @RequestBody PlanoModel planoModel) {
        PlanoModel atualizado = planoService.atualizar(id, planoModel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        planoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
