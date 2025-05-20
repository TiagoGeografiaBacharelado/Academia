package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.PlanoModels;
import com.example.SmartAcademy.interfaces.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoApplication {

    private PlanoRepository planoRepository;

    @Autowired
    public void setPlanoRepository(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public void adicionar(PlanoModels plano) {
        planoRepository.save(plano);
    }

    public void atualizar(PlanoModels plano) {
        planoRepository.save(plano);
    }

    public void remover(int codigo) {
        planoRepository.deleteById(codigo);
    }

    public List<PlanoModels> buscar() {
        return planoRepository.findAll();
    }

    public PlanoModels buscarPorCodigo(int codigo) {
        return planoRepository.findById(codigo).orElse(null);
    }
}
