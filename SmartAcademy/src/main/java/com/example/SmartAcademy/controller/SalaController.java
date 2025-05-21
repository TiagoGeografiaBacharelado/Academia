package com.example.SmartAcademy.controller;

import com.example.SmartAcademy.applications.SalaApplication;
import com.example.SmartAcademy.models.SalaModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaApplication salaApplication;

    @Autowired
    public SalaController(SalaApplication salaApplication) {
        this.salaApplication = salaApplication;
    }

    @PostMapping
    public void adicionar(@RequestBody SalaModels sala) {
        salaApplication.adicionar(sala);
    }

    @PutMapping
    public void atualizar(@RequestBody SalaModels sala) {
        salaApplication.atualizar(sala);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        salaApplication.remover(codigo);
    }

    @GetMapping
    public List<SalaModels> buscar() {
        return salaApplication.buscar();
    }

    @GetMapping("/{codigo}")
    public SalaModels buscarPorCodigo(@PathVariable int codigo) {
        return salaApplication.buscarPorCodigo(codigo);
    }
}
