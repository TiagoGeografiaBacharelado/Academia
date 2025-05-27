package com.example.SmartAcademy.controllers; // Pacote de controllers

import com.example.SmartAcademy.models.ClienteModel; // DTO para transporte
import com.example.SmartAcademy.services.ClienteService; // Serviço de negócio
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.http.ResponseEntity; // Respostas HTTP
import org.springframework.web.bind.annotation.*; // Anotações REST

import java.net.URI; // Para header Location
import java.util.List; // Listagem
import java.util.Optional; // Optional

@RestController // Define controller REST
@RequestMapping("/api/clientes") // Mapeia rota base
public class ClienteController { // Classe de controller

    private final ClienteService clienteService; // Dependência do serviço

    @Autowired // Injeta via construtor
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService; // Atribuição
    }

    @GetMapping // GET /api/clientes
    public ResponseEntity<List<ClienteModel>> listarTodos() {
        List<ClienteModel> lista = clienteService.listarTodos(); // Busca lista
        return ResponseEntity.ok(lista); // HTTP 200 com corpo
    }

    @GetMapping("/{id}") // GET /api/clientes/{id}
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long id) {
        Optional<ClienteModel> optional = clienteService.buscarPorId(id); // Busca por ID
        return optional
                .map(ResponseEntity::ok) // Se presente, 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se ausente, 404
    }

    @PostMapping // POST /api/clientes
    public ResponseEntity<ClienteModel> criar(@RequestBody ClienteModel clienteModel) {
        ClienteModel criado = clienteService.criar(clienteModel); // Cria cliente
        URI location = URI.create("/api/clientes/" + criado.getId()); // URI do recurso
        return ResponseEntity.created(location).body(criado); // HTTP 201 Created
    }

    @PutMapping("/{id}") // PUT /api/clientes/{id}
    public ResponseEntity<ClienteModel> atualizar(@PathVariable Long id,
                                                  @RequestBody ClienteModel clienteModel) {
        ClienteModel atualizado = clienteService.atualizar(id, clienteModel); // Atualiza
        return ResponseEntity.ok(atualizado); // HTTP 200 OK
    }

    @DeleteMapping("/{id}") // DELETE /api/clientes/{id}
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id); // Deleta recurso
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

}