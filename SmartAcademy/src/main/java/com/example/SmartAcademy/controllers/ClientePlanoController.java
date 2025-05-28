package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.ClientePlanoModel;
import com.example.SmartAcademy.services.ClientePlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente-plano")
public class ClientePlanoController {

    private final ClientePlanoService clientePlanoService;

    @Autowired
    public ClientePlanoController(ClientePlanoService clientePlanoService) {
        this.clientePlanoService = clientePlanoService;
    }

    @GetMapping
    public ResponseEntity<List<ClientePlanoModel>> listarTodos() {
        List<ClientePlanoModel> lista = clientePlanoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePlanoModel> buscarPorId(@PathVariable Long id) {
        Optional<ClientePlanoModel> optional = clientePlanoService.buscarPorId(id);
        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientePlanoModel> criar(@RequestBody ClientePlanoModel clientePlanoModel) {
        ClientePlanoModel criado = clientePlanoService.criar(clientePlanoModel);
        URI location = URI.create("/api/cliente-plano/" + criado.getId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePlanoModel> atualizar(@PathVariable Long id,
                                                       @RequestBody ClientePlanoModel clientePlanoModel) {
        ClientePlanoModel atualizado = clientePlanoService.atualizar(id, clientePlanoModel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clientePlanoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}