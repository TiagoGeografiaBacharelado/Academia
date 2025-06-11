package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import com.example.SmartAcademy.services.AtividadeInstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividade_instrutor/app")
public class AtividadeInstrutorApplication {

    private final AtividadeInstrutorService atividadeInstrutorService;

    @Autowired
    public AtividadeInstrutorApplication(AtividadeInstrutorService atividadeInstrutorService) {
        this.atividadeInstrutorService = atividadeInstrutorService;
    }


    @GetMapping
    public ResponseEntity<List<AtividadeInstrutorModel>> listarTodos() {
        List<AtividadeInstrutorModel> clientes = atividadeInstrutorService.listarTodos();
        return ResponseEntity.ok(clientes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AtividadeInstrutorModel> buscarPorId(@PathVariable int id) {
        return atividadeInstrutorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        atividadeInstrutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}