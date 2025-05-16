package com.geriaTeam.geriatricare.controllers;

import com.geriaTeam.geriatricare.applications.TurmaApplication;
import com.geriaTeam.geriatricare.models.TurmaModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaApplication turmaApplication;

    @Autowired
    public TurmaController(TurmaApplication turmaApplication) {
        this.turmaApplication = turmaApplication;
    }

    @PostMapping
    public void adicionar(@RequestBody TurmaModels turma) {
        turmaApplication.adicionar(turma);
    }

    @PutMapping
    public void atualizar(@RequestBody TurmaModels turma) {
        turmaApplication.atualizar(turma);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        turmaApplication.remover(codigo);
    }

    @GetMapping
    public List<TurmaModels> buscar() {
        return turmaApplication.buscar();
    }

    @GetMapping("/{codigo}")
    public TurmaModels buscarPorCodigo(@PathVariable int codigo) {
        return turmaApplication.buscarPorCodigo(codigo);
    }
}
