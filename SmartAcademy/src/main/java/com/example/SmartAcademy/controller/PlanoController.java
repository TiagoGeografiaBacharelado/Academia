package com.example.SmartAcademy.controller;

import com.example.SmartAcademy.applications.PlanoApplication;
import com.example.SmartAcademy.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoApplication planoApplication;

    @Autowired
    public PlanoController(PlanoApplication planoApplication) {
        this.planoApplication = planoApplication;
    }

    @PostMapping
    public void adicionar(@RequestBody PlanoModels plano) {
        planoApplication.adicionar(plano);
    }

    @PutMapping
    public void atualizar(@RequestBody PlanoModels plano) {
        planoApplication.atualizar(plano);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        planoApplication.remover(codigo);
    }

    @GetMapping
    public List<PlanoModels> buscar() {
        return planoApplication.buscar();
    }

    @GetMapping("/{codigo}")
    public PlanoModels buscarPorCodigo(@PathVariable int codigo) {
        return planoApplication.buscarPorCodigo(codigo);
    }
}
