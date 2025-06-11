package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.interfaces.AtividadePlanoRepository;
import com.example.SmartAcademy.models.AtividadeInstrutorModel;
import com.example.SmartAcademy.models.AtividadePlanoModel;
import com.example.SmartAcademy.models.AtividadeModel;
import com.example.SmartAcademy.models.PlanoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AtividadePlanoMySQLImpl implements AtividadePlanoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AtividadePlanoModel> buscarTodos() {
        return entityManager.createQuery("SELECT ap FROM AtividadePlanoModel ap", AtividadePlanoModel.class)
                .getResultList();
    }

    @Override
    public Optional<AtividadePlanoModel> buscarPorCodigo(int id) {
        AtividadePlanoModel model = entityManager.find(AtividadePlanoModel.class, id);
        return Optional.ofNullable(model);
    }

    @Override
    public void adicionar(AtividadePlanoModel model) {
        AtividadeModel atividade = entityManager.find(AtividadeModel.class, model.getAtividade().getId());
        PlanoModel plano = entityManager.find(PlanoModel.class, model.getPlano().getId());

        if (atividade == null || plano == null) {
            throw new IllegalArgumentException("Atividade ou Plano não encontrados.");
        }

        model.setAtividade(atividade);
        model.setPlano(plano);

        entityManager.persist(model);
    }

    @Override
    public void atualizar(AtividadePlanoModel model) {
        AtividadePlanoModel existente = entityManager.find(AtividadePlanoModel.class, model.getId());
        if (existente == null) {
            throw new IllegalArgumentException("AtividadePlano não encontrado com ID: " + model.getId());
        }

        AtividadeModel atividade = entityManager.find(AtividadeModel.class, model.getAtividade().getId());
        PlanoModel plano = entityManager.find(PlanoModel.class, model.getPlano().getId());

        if (atividade == null || plano == null) {
            throw new IllegalArgumentException("Atividade ou Plano não encontrados.");
        }

        existente.setAtividade(atividade);
        existente.setPlano(plano);
        existente.setCpf(model.getCpf());
        existente.setObservacao(model.getObservacao());

        entityManager.merge(existente);
    }

    @Override
    public void remover(int id) {
        AtividadePlanoModel entidade = entityManager.find(AtividadePlanoModel.class, id);
        if (entidade != null) {
            entityManager.remove(entidade);
        }
    }

    @Override
    public Optional<AtividadeInstrutorModel> buscarPorCpf(String cpf) {

        return Optional.empty();
    }
}
