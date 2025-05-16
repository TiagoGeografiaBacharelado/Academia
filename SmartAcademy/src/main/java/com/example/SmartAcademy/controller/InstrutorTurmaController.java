package com.example.SmartAcademy.controller;

import com.example.SmartAcademy.applications.InstrutorTurmaApplication;
import com.example.SmartAcademy.models.InstrutorTurmaModels;

import java.util.List;

@RestController
@RequestMapping("/instrutores-turmas")
public class InstrutorTurmaController {

    private final InstrutorTurmaApplication instrutorTurmaApplication;

    @Autowired
    public InstrutorTurmaController(InstrutorTurmaApplication instrutorTurmaApplication) {
        this.instrutorTurmaApplication = instrutorTurmaApplication;
    }

    @PostMapping
    public void adicionar(@RequestBody InstrutorTurmaModels instrutorTurma) {
        instrutorTurmaApplication.adicionar(instrutorTurma);
    }

    @PutMapping
    public void atualizar(@RequestBody InstrutorTurmaModels instrutorTurma) {
        instrutorTurmaApplication.atualizar(instrutorTurma);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        instrutorTurmaApplication.remover(codigo);
    }

    @GetMapping
    public List<InstrutorTurmaModels> buscar() {
        return instrutorTurmaApplication.buscar();
    }

    @GetMapping("/{codigo}")
    public InstrutorTurmaModels buscarPorCodigo(@PathVariable int codigo) {
        return instrutorTurmaApplication.buscarPorCodigo(codigo);
    }
}
