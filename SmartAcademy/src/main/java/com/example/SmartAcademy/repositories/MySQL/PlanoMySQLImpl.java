package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.interfaces.PlanoRepository;
import com.example.SmartAcademy.models.PlanoModels;
import com.example.SmartAcademy.repositories.jpa.PlanoJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanoMySQLImpl implements PlanoRepository {

    private static final Logger logger = LoggerFactory.getLogger(PlanoMySQLImpl.class);
    private final PlanoJPA planoJPA;

    public PlanoMySQLImpl(PlanoJPA planoJPA) {
        this.planoJPA = planoJPA;
    }

    @Override
    public void adicionar(PlanoModels plano) {
        try {
            planoJPA.save(plano);
        } catch (Exception e) {
            logger.error("Erro ao salvar o plano: {}", plano, e);
        }
    }

    @Override
    public void atualizar(PlanoModels plano) {
        try {
            planoJPA.save(plano);
        } catch (Exception e) {
            logger.error("Erro ao atualizar o plano: {}", plano, e);
        }
    }

    @Override
    public void remover(int codigo) {
        if (planoJPA.existsById(codigo)) {
            try {
                planoJPA.deleteById(codigo);
            } catch (Exception e) {
                logger.error("Erro ao remover o plano com ID: {}", codigo, e);
            }
        } else {
            logger.warn("Tentativa de remover plano inexistente com ID: {}", codigo);
        }
    }

    @Override
    public List<PlanoModels> buscar() {
        return planoJPA.findAll();
    }

    @Override
    public PlanoModels buscarPorCodigo(int codigo) {
        return planoJPA.findById(codigo).orElse(null);
    }

    @Override
    public List<PlanoModels> buscarPorNome(String nome) {
        try {
            return planoJPA.findByNome(nome);
        } catch (Exception e) {
            logger.error("Erro ao buscar plano por nome: {}", nome, e);
            return List.of();
        }
    }
}
