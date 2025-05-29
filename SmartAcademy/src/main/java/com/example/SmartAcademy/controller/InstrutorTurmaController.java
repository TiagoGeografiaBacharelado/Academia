package com.example.SmartAcademy.controller;

import com.example.SmartAcademy.models.InstrutorTurmaModel;
import com.example.SmartAcademy.services.InstrutorTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instrutorturmas")
public class InstrutorTurmaController {

    private final InstrutorTurmaService instrutorTurmaService;

    @Autowired
    public InstrutorTurmaController(InstrutorTurmaService instrutorTurmaService) {
        this.instrutorTurmaService = instrutorTurmaService;
    }

    @GetMapping
    public ResponseEntity<List<InstrutorTurmaModel>> listarTodas() {
        return ResponseEntity.ok(instrutorTurmaService.listarTodas());
    }

    @GetMapping("/{idInstrutor}/{idTurma}")
    public ResponseEntity<InstrutorTurmaModel> buscarPorIds(@PathVariable Long idInstrutor,
                                                            @PathVariable Long idTurma) {
        Optional<InstrutorTurmaModel> optional = instrutorTurmaService.buscarPorIds(idInstrutor, idTurma);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrutorTurmaModel> criar(@RequestBody InstrutorTurmaModel model) {
        InstrutorTurmaModel criado = instrutorTurmaService.criar(model);
        URI location = URI.create("/api/instrutorturmas/" + criado.getInstrutorId() + "/" + criado.getTurmaId());
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{idInstrutor}/{idTurma}")
    public ResponseEntity<InstrutorTurmaModel> atualizar(@PathVariable Long idInstrutor,
                                                         @PathVariable Long idTurma,
                                                         @RequestBody InstrutorTurmaModel model) {
        InstrutorTurmaModel atualizado = instrutorTurmaService.atualizar(idInstrutor, idTurma, model);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{idInstrutor}/{idTurma}")
    public ResponseEntity<Void> deletar(@PathVariable Long idInstrutor, @PathVariable Long idTurma) {
        instrutorTurmaService.deletar(idInstrutor, idTurma);
        return ResponseEntity.noContent().build();
    }
}
