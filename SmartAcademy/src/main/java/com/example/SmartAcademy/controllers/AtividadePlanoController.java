package com.example.SmartAcademy.controllers; // Pacote de controllers

import com.example.SmartAcademy.models.AtividadePlanoModel; // DTO para transporte
import com.example.SmartAcademy.services.AtividadePlanoService; // Serviço de negócio
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.http.ResponseEntity; // Respostas HTTP
import org.springframework.web.bind.annotation.*; // Anotações REST

import java.net.URI; // Para header Location
import java.util.List; // Listagem
import java.util.Optional; // Optional

@RestController // Define controller REST
@RequestMapping("/api/atividade_plano") // Mapeia rota base
public class AtividadePlanoController { // Classe de controller

    private final AtividadePlanoService atividadePlanoService; // Dependência do serviço

    @Autowired // Injeta via construtor
    public AtividadePlanoController(AtividadePlanoService atividadePlanoService) {
        this.atividadePlanoService = atividadePlanoService; // Atribuição
    }

    @GetMapping // GET /api/atividade-plano
    public ResponseEntity<List<AtividadePlanoModel>> listarTodos() {
        List<AtividadePlanoModel> lista = atividadePlanoService.listarTodos(); // Busca lista
        return ResponseEntity.ok(lista); // HTTP 200 com corpo
    }

    @GetMapping("/{id}") // GET /api/atividade-plano/{id}
    public ResponseEntity<Optional<AtividadePlanoModel>> buscarPorId(@PathVariable int id) {
        Optional<Optional<AtividadePlanoModel>> optional = atividadePlanoService.buscarPorId(id); // Busca por ID
        return optional
                .map(ResponseEntity::ok) // Se presente, 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se ausente, 404
    }

    @PostMapping // POST /api/atividade-plano
    public ResponseEntity<AtividadePlanoModel> criar(@RequestBody AtividadePlanoModel model) {
        AtividadePlanoModel criado = atividadePlanoService.criar(model); // Cria associação
        URI location = URI.create("/api/atividade_plano/" + criado.getId()); // URI do recurso
        return ResponseEntity.created(location).body(criado); // HTTP 201 Created
    }

    @PutMapping("/{id}") // PUT /api/atividade-plano/{id}
    public ResponseEntity<AtividadePlanoModel> atualizar(@PathVariable int id,
                                                         @RequestBody AtividadePlanoModel model) {
        AtividadePlanoModel atualizado = atividadePlanoService.atualizar(id, model); // Atualiza
        return ResponseEntity.ok(atualizado); // HTTP 200 OK
    }

    @DeleteMapping("/{id}") // DELETE /api/atividade-plano/{id}
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadePlanoService.deletar(id); // Deleta recurso
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
