package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.ClientePlanoModel;
import com.example.SmartAcademy.services.ClientePlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente-plano/app")
public class ClientePlanoApplication {

    private final ClientePlanoService clientePlanoService;

    @Autowired
    public ClientePlanoApplication(ClientePlanoService clientePlanoService) {
        this.clientePlanoService = clientePlanoService;
    }

    @GetMapping
    public ResponseEntity<List<ClientePlanoModel>> listarTodos() {
        List<ClientePlanoModel> lista = clientePlanoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePlanoModel> buscarPorId(@PathVariable Long id) {
        return clientePlanoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientePlanoModel> criar(@RequestBody ClientePlanoModel clientePlanoModel) {
        ClientePlanoModel criado = clientePlanoService.criar(clientePlanoModel);
        return ResponseEntity.ok(criado);
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