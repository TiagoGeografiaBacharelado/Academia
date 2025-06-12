package com.example.SmartAcademy.controllers; // Pacote de controllers

import com.example.SmartAcademy.models.PlanoModel; // DTO para transporte
import com.example.SmartAcademy.services.PlanoService; // Serviço de negócio
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.http.ResponseEntity; // Respostas HTTP
import org.springframework.web.bind.annotation.*; // Anotações REST

import java.net.URI; // Para header Location
import java.util.List; // Listagem
import java.util.Optional; // Optional

@RestController // Define controller REST
@RequestMapping("/api/planos") // Mapeia rota base
public class PlanoController { // Classe de controller

    private final PlanoService planoService; // Dependência do serviço

    @Autowired // Injeta via construtor
    public PlanoController(PlanoService planoService) {
        this.planoService = planoService; // Atribuição
    }

    @GetMapping // GET /api/clientes
    public ResponseEntity<List<PlanoModel>> listarTodos() {
        List<PlanoModel> lista = planoService.listarTodos(); // Busca lista
        return ResponseEntity.ok(lista); // HTTP 200 com corpo
    }

    @GetMapping("/{id}") // GET /api/clientes/{id}
    public ResponseEntity<PlanoModel> buscarPorId(@PathVariable int id) {
        Optional<PlanoModel> optional = planoService.buscarPorId(id); // Busca por ID
        return optional
                .map(ResponseEntity::ok) // Se presente, 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se ausente, 404
    }

    @PostMapping // POST /api/clientes
    public ResponseEntity<PlanoModel> criar(@RequestBody PlanoModel planoModel) {
        PlanoModel criado = planoService.criar(planoModel); // Cria cliente
        URI location = URI.create("/api/planos/" + criado.getId()); // URI do recurso
        return ResponseEntity.created(location).body(criado); // HTTP 201 Created
    }

    @PutMapping("/{id}") // PUT /api/planos/{id}
    public ResponseEntity<PlanoModel> atualizar(@PathVariable int id,
                                                  @RequestBody PlanoModel planoModel) {
        PlanoModel atualizado = planoService.atualizar(id, planoModel); // Atualiza
        return ResponseEntity.ok(atualizado); // HTTP 200 OK
    }

    @DeleteMapping("/{id}") // DELETE /api/clientes/{id}
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        planoService.deletar(id); // Deleta recurso
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

}
