package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.ClienteModels;
import com.example.SmartAcademy.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // GET /api/clientes
    @GetMapping
    public ResponseEntity<List<ClienteModels>> listarTodos() {
        List<ClienteModels> clientes = clienteRepository.buscarTodos();
        return ResponseEntity.ok(clientes);
    }

    // GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModels> buscarPorId(@PathVariable Integer id) {
        Optional<ClienteModels> optional = clienteRepository.buscarPorCodigo(id);
        return optional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/clientes
    @PostMapping
    public ResponseEntity<ClienteModels> criar(@RequestBody ClienteModels cliente) {
        clienteRepository.adicionar(cliente);
        return ResponseEntity.ok(cliente);
    }

    // PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModels> atualizar(@PathVariable Integer id,
                                                   @RequestBody ClienteModels cliente) {
        Optional<ClienteModels> existente = clienteRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);  // certificar que id está sincronizado
        clienteRepository.atualizar(cliente);
        return ResponseEntity.ok(cliente);
    }

    // DELETE /api/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        Optional<ClienteModels> existente = clienteRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.remover(id);
        return ResponseEntity.noContent().build();
    }
}