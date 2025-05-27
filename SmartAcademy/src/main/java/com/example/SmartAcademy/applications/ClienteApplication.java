package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.ClienteModel;
import com.example.SmartAcademy.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes/app")
public class ClienteApplication {

    private final ClienteService clienteService;

    @Autowired
    public ClienteApplication(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // GET /api/clientes
    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarTodos() {
        List<ClienteModel> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/clientes
    @PostMapping
    public ResponseEntity<ClienteModel> criar(@RequestBody ClienteModel clienteModel) {
        ClienteModel criado = clienteService.criar(clienteModel);
        return ResponseEntity.ok(criado);
    }

    // PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizar(@PathVariable Long id,
                                                  @RequestBody ClienteModel clienteModel) {
        ClienteModel atualizado = clienteService.atualizar(id, clienteModel);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /api/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
