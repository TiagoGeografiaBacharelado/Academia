package com.example.SmartAcademy.controllers;

import com.example.SmartAcademy.models.FormaPagamentoModels;
import com.example.SmartAcademy.repositories.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/formas-pagamento")
public class FormaPagamentoController {

    private final FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    public FormaPagamentoController(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    // GET /api/formas-pagamento
    @GetMapping
    public ResponseEntity<List<FormaPagamentoModels>> listarTodos() {
        List<FormaPagamentoModels> lista = formaPagamentoRepository.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    // GET /api/formas-pagamento/{id}
    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoModels> buscarPorId(@PathVariable Integer id) {
        Optional<FormaPagamentoModels> opt = formaPagamentoRepository.buscarPorCodigo(id);
        return opt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/formas-pagamento
    @PostMapping
    public ResponseEntity<FormaPagamentoModels> criar(@RequestBody FormaPagamentoModels forma) {
        formaPagamentoRepository.adicionar(forma);
        return ResponseEntity.ok(forma);
    }

    // PUT /api/formas-pagamento/{id}
    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamentoModels> atualizar(@PathVariable Integer id,
                                                          @RequestBody FormaPagamentoModels forma) {
        Optional<FormaPagamentoModels> existente = formaPagamentoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        forma.setId(id);
        formaPagamentoRepository.atualizar(forma);
        return ResponseEntity.ok(forma);
    }

    // DELETE /api/formas-pagamento/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        Optional<FormaPagamentoModels> existente = formaPagamentoRepository.buscarPorCodigo(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        formaPagamentoRepository.remover(id);
        return ResponseEntity.noContent().build();
    }
}