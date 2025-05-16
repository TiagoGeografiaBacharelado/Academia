package com.example.SmartAcademy.controller;

import com.example.SmartAcademy.applications.InstrutorApplication;
import com.example.SmartAcademy.models.InstrutorModels;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    private final InstrutorApplication instrutorApplication;

    @Autowired
    public InstrutorController(InstrutorApplication instrutorApplication) {
        this.instrutorApplication = instrutorApplication;
    }

    @PostMapping
    public void adicionar(@RequestBody InstrutorModels instrutor) {
        instrutorApplication.adicionar(instrutor);
    }

    @PutMapping
    public void atualizar(@RequestBody InstrutorModels instrutor) {
        instrutorApplication.atualizar(instrutor);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        instrutorApplication.remover(codigo);
    }

    @GetMapping
    public List<InstrutorModels> buscar() {
        return instrutorApplication.buscar();
    }

    @GetMapping("/{codigo}")
    public InstrutorModels buscarPorCodigo(@PathVariable int codigo) {
        return instrutorApplication.buscarPorCodigo(codigo);
    }
}
