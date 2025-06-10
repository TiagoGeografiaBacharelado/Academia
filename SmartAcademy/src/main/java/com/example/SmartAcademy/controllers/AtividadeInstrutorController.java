package com.example.SmartAcademy.controllers; // Pacote de controllers

import com.example.SmartAcademy.models.AtividadeInstrutorModel; // DTO para transporte
import com.example.SmartAcademy.services.AtividadeInstrutorService; // Serviço de negócio
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.http.ResponseEntity; // Respostas HTTP
import org.springframework.web.bind.annotation.*; // Anotações REST

import java.net.URI; // Para header Location
import java.util.List; // Listagem
import java.util.Optional; // Optional

@RestController // Define controller REST
@RequestMapping("/api/atividade_instrutor") // Mapeia rota base
public class AtividadeInstrutorController { // Classe de controller

    private final AtividadeInstrutorService atividadeInstrutorService; // Dependência do serviço

    @Autowired
    public AtividadeInstrutorController(AtividadeInstrutorService atividadeInstrutorService) {
        this.atividadeInstrutorService = atividadeInstrutorService; // Atribuição
    }

    @GetMapping // GET /api/atividade-instrutor
    public ResponseEntity<List<AtividadeInstrutorModel>> listarTodos() {
        List<AtividadeInstrutorModel> lista = atividadeInstrutorService.listarTodos(); // Busca lista
        return ResponseEntity.ok(lista); // HTTP 200 com corpo
    }

    @GetMapping("/{id}") // GET /api/atividade-instrutor/{id}
    public ResponseEntity<AtividadeInstrutorModel> buscarPorId(@PathVariable int id) {
        Optional<AtividadeInstrutorModel> optional = atividadeInstrutorService.buscarPorId(id); // Busca por ID
        return optional
                .map(ResponseEntity::ok) // Se presente, 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se ausente, 404
    }

    @PostMapping // POST /api/atividade-instrutor
    public ResponseEntity<AtividadeInstrutorModel> criar(@RequestBody AtividadeInstrutorModel model) {
        AtividadeInstrutorModel criado = atividadeInstrutorService.criar(model); // Cria associação
        URI location = URI.create("/api/atividade_instrutor/" + criado.getId()); // URI do recurso
        return ResponseEntity.created(location).body(criado); // HTTP 201 Created
    }

    @PutMapping("/{id}") // PUT /api/atividade-instrutor/{id}
    public ResponseEntity<AtividadeInstrutorModel> atualizar(@PathVariable int id,
                                                             @RequestBody AtividadeInstrutorModel model) {
        AtividadeInstrutorModel atualizado = atividadeInstrutorService.atualizar(id, model); // Atualiza
        return ResponseEntity.ok(atualizado); // HTTP 200 OK
    }

    @DeleteMapping("/{id}") // DELETE /api/atividade-instrutor/{id}
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadeInstrutorService.deletar(id); // Deleta recurso
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
