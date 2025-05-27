package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.InstrutorTurmaModel;
import com.example.SmartAcademy.services.InstrutorTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutorturmas/app")
public class InstrutorTurmaApplication {

    private final InstrutorTurmaService instrutorTurmaService;

    @Autowired
    public InstrutorTurmaApplication(InstrutorTurmaService instrutorTurmaService) {
        this.instrutorTurmaService = instrutorTurmaService;
    }

    @GetMapping
    public ResponseEntity<List<InstrutorTurmaModel>> listarTodas() {
        return ResponseEntity.ok(instrutorTurmaService.listarTodas());
    }

    @GetMapping("/{idInstrutor}/{idTurma}")
    public ResponseEntity<InstrutorTurmaModel> buscarPorIds(@PathVariable Long idInstrutor, @PathVariable Long idTurma) {
        return instrutorTurmaService.buscarPorIds(idInstrutor, idTurma)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrutorTurmaModel> criar(@RequestBody InstrutorTurmaModel model) {
        return ResponseEntity.ok(instrutorTurmaService.criar(model));
    }

    @PutMapping("/{idInstrutor}/{idTurma}")
    public ResponseEntity<InstrutorTurmaModel> atualizar(@PathVariable Long idInstrutor,
                                                         @PathVariable Long idTurma,
                                                         @RequestBody InstrutorTurmaModel model) {
        return ResponseEntity.ok(instrutorTurmaService.atualizar(idInstrutor, idTurma, model));
    }

    @DeleteMapping("/{idInstrutor}/{idTurma}")
    public ResponseEntity<Void> deletar(@PathVariable Long idInstrutor, @PathVariable Long idTurma) {
        instrutorTurmaService.deletar(idInstrutor, idTurma);
        return ResponseEntity.noContent().build();
    }
}
