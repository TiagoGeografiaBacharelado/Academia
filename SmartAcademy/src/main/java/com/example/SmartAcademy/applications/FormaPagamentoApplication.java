package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.FormaPagamentoModel;
import com.example.SmartAcademy.services.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formas-pagamento/app")
public class FormaPagamentoApplication {

    private final FormaPagamentoService formaPagamentoService;

    @Autowired
    public FormaPagamentoApplication(FormaPagamentoService formaPagamentoService) {
        this.formaPagamentoService = formaPagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamentoModel>> listarTodos() {
        return ResponseEntity.ok(formaPagamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoModel> buscarPorId(@PathVariable Long id) {
        return formaPagamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FormaPagamentoModel> criar(@RequestBody FormaPagamentoModel model) {
        FormaPagamentoModel criado = formaPagamentoService.criar(model);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamentoModel> atualizar(@PathVariable Long id,
                                                         @RequestBody FormaPagamentoModel model) {
        FormaPagamentoModel atualizado = formaPagamentoService.atualizar(id, model);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        formaPagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}