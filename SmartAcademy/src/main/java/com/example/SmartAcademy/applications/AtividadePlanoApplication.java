package com.example.SmartAcademy.applications;

import com.example.SmartAcademy.models.AtividadePlanoModels;
import com.example.SmartAcademy.interfaces.AtividadePlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadePlanoApplication {

    private AtividadePlanoRepository atividadePlanoRepository;

    @Autowired
    public void setAtividadePlanoRepository(AtividadePlanoRepository atividadePlanoRepository) {
        this.atividadePlanoRepository = atividadePlanoRepository;
    }

    public void adicionar(AtividadePlanoModels atividadePlano) {
        atividadePlanoRepository.save(atividadePlano);
    }

    public void atualizar(AtividadePlanoModels atividadePlano) {
        atividadePlanoRepository.save(atividadePlano);
    }

    public void remover(int codigo) {
        atividadePlanoRepository.deleteById(codigo);
    }

    public List<AtividadePlanoModels> buscar() {
        return atividadePlanoRepository.findAll();
    }

    public AtividadePlanoModels buscarPorCodigo(int codigo) {
        return atividadePlanoRepository.findById(codigo).orElse(null);
    }
}
