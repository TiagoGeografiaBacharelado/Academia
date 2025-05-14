package com.example.SmartAcademy.controller;


import com.example.SmartAcademy.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    private final PlanoRepository planoRepository;

    @Autowired
    public PlanoController(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @GetMapping("")
    public List<Plano> getAll() {
        return planoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Plano getById(@PathVariable Long id) {
        return planoRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public Plano save(@RequestBody Plano plano) {
        return planoRepository.save(plano);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Plano update(@PathVariable Long id, @RequestBody Plano plano) {
        plano.setId(id);
        return planoRepository.save(plano);
    }
}
