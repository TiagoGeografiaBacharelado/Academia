package com.example.SmartAcademy.controllers; // Pacote de controllers

import com.example.SmartAcademy.models.AtividadeModel; // DTO para transporte
import com.example.SmartAcademy.services.AtividadeService; // Serviço de negócio
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.http.ResponseEntity; // Respostas HTTP
import org.springframework.web.bind.annotation.*; // Anotações REST

import java.net.URI; // Para header Location
import java.util.List; // Listagem
import java.util.Optional; // Optional

@RestController // Define controller REST
@RequestMapping("/api/atividades") // Mapeia rota base
public class AtividadeController { // Classe de controller

    private final AtividadeService atividadeService; // Dependência do serviço

    @Autowired // Injeta via construtor
    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService; // Atribuição
    }

    @GetMapping // GET /api/clientes
    public ResponseEntity<List<AtividadeModel>> listarTodos() {
        List<AtividadeModel> lista = atividadeService.listarTodos(); // Busca lista
        return ResponseEntity.ok(lista); // HTTP 200 com corpo
    }

    @GetMapping("/{id}") // GET /api/clientes/{id}
    public ResponseEntity<Optional<AtividadeModel>> buscarPorId(@PathVariable int id) {
        Optional<Optional<AtividadeModel>> optional = atividadeService.buscarPorId(id); // Busca por ID
        return optional
                .map(ResponseEntity::ok) // Se presente, 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se ausente, 404
    }

    @PostMapping // POST /api/clientes
    public ResponseEntity<AtividadeModel> criar(@RequestBody AtividadeModel atividadeModel) {
        AtividadeModel criado = atividadeService.criar(atividadeModel); // Cria cliente
        URI location = URI.create("/api/atividades/" + criado.getId()); // URI do recurso
        return ResponseEntity.created(location).body(criado); // HTTP 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeModel> atualizar(@PathVariable int id,
                                                  @RequestBody AtividadeModel atividadeModel) {
        AtividadeModel atualizado = atividadeService.atualizar(id, atividadeModel); // Atualiza
        return ResponseEntity.ok(atualizado); // HTTP 200 OK
    }

    @DeleteMapping("/{id}") // DELETE /api/clientes/{id}
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadeService.deletar(id); // Deleta recurso
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

}