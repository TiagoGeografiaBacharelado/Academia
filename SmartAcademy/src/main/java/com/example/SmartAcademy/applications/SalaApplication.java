package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.interfaces.SalaRepository;
import com.geriaTeam.geriatricare.models.SalaModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaApplication {

    private final SalaRepository salaRepository;

    @Autowired
    public SalaApplication(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public void adicionar(SalaModels sala) {
        salaRepository.adicionar(sala);
    }

    public void atualizar(SalaModels sala) {
        salaRepository.atualizar(sala);
    }

    public void remover(int codigo) {
        salaRepository.remover(codigo);
    }

    public List<SalaModels> buscar() {
        return salaRepository.buscar();
    }

    public SalaModels buscarPorCodigo(int codigo) {
        return salaRepository.buscarPorCodigo(codigo);
    }
}
