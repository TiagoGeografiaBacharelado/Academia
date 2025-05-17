package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.ClientePlanoModels;
import com.example.SmartAcademy.repositories.ClientePlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente-planos")
public class ClientePlanoController {

    private final ClientePlanoRepository clientePlanoRepository;

    @Autowired
    public ClientePlanoController(ClientePlanoRepository clientePlanoRepository) {
        this.clientePlanoRepository = clientePlanoRepository;
    }

    // GET /api/cliente-planos
    @GetMapping
    public ResponseEntity<List<ClientePlanoModels>> listarTodos() {
        List<ClientePlanoModels> lista = clientePlanoRepository.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    // GET /api/cliente-planos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ClientePlanoModels> buscarPorCodigo(@PathVariable Integer id) {
        Optional<ClientePlanoModels> opt = clientePlanoRepository.buscarPorCodigo(id);
        return opt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/cliente-planos
    @PostMapping
    public ResponseEntity<ClientePlanoModels> criar(@RequestBody ClientePlanoModels clientePlano) {
        clientePlanoRepository.adicionar(clientePlano);
        return ResponseEntity.ok(clientePlano);
    }

    // PUT /api/cliente-planos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ClientePlanoModels> atualizar(@PathVariable Integer id,
                                                        @RequestBody ClientePlanoModels clientePlano) {
        Optional<ClientePlanoModels> existente = clientePlanoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientePlano.setId(id);
        clientePlanoRepository.atualizar(clientePlano);
        return ResponseEntity.ok(clientePlano);
    }

    // DELETE /api/cliente-planos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        Optional<ClientePlanoModels> existente = clientePlanoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientePlanoRepository.remover(id);
        return ResponseEntity.noContent().build();
    }
}