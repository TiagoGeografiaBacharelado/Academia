package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.interfaces.AtividadeRepository;
import com.example.SmartAcademy.models.AtividadeModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AtividadeMySQLImpl implements AtividadeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<AtividadeModel> buscarPorCodigo(int id) {
        AtividadeModel atividade = entityManager.find(AtividadeModel.class, id);
        return Optional.ofNullable(atividade);
    }

    @Override
    public List<AtividadeModel> buscarTodos() {
        return entityManager.createQuery("SELECT a FROM AtividadeModel a", AtividadeModel.class).getResultList();
    }

    @Override
    public void adicionar(AtividadeModel atividadeModel) {
        entityManager.persist(atividadeModel);
    }

    @Override
    public void atualizar(AtividadeModel atividadeModel) {
        entityManager.merge(atividadeModel);
    }

    @Override
    public void remover(int id) {
        AtividadeModel atividade = entityManager.find(AtividadeModel.class, id);
        if (atividade != null) {
            entityManager.remove(atividade);
        }
    }

    @Override
    public Optional<AtividadeModel> buscarPorCpf(String cpf) {
        return Optional.empty();
    }
}
