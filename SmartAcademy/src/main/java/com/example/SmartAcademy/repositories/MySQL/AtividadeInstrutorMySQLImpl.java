package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.AtividadeInstrutor;
import com.example.SmartAcademy.entities.Atividade;
import com.example.SmartAcademy.entities.Instrutor;
import com.example.SmartAcademy.interfaces.AtividadeInstrutorRepository;
import com.example.SmartAcademy.models.AtividadeInstrutorModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class AtividadeInstrutorMySQLImpl implements AtividadeInstrutorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<AtividadeInstrutorModel> buscarPorCodigo(int id) {
        AtividadeInstrutor entidade = entityManager.find(AtividadeInstrutor.class, id);
        return Optional.ofNullable(entidade).map(this::toModel);
    }

    @Override
    public List<AtividadeInstrutorModel> buscarTodos() {
        return entityManager.createQuery("FROM AtividadeInstrutor", AtividadeInstrutor.class)
                .getResultList()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(AtividadeInstrutorModel model) {
        entityManager.persist(toEntity(model));
    }

    @Override
    public void atualizar(AtividadeInstrutorModel model) {
        entityManager.merge(toEntity(model));
    }

    @Override
    public void remover(int id) {
        AtividadeInstrutor entidade = entityManager.find(AtividadeInstrutor.class, id);
        if (entidade != null) {
            entityManager.remove(entidade);
        }
    }

    @Override
    public Optional<AtividadeInstrutorModel> buscarPorCpf(String cpf) {
        List<AtividadeInstrutor> lista = entityManager.createQuery(
                        "SELECT ai FROM AtividadeInstrutor ai WHERE ai.instrutor.cpf = :cpf", AtividadeInstrutor.class)
                .setParameter("Cpf", cpf)
                .getResultList();

        return lista.isEmpty() ? Optional.empty() : Optional.of(toModel(lista.get(0)));
    }

    private AtividadeInstrutorModel toModel(AtividadeInstrutor entidade) {
        AtividadeInstrutorModel model = new AtividadeInstrutorModel();
        model.setId(entidade.getId());

        if (entidade.getInstrutor() != null) {
            model.setNomeInstrutor(entidade.getInstrutor().getNome());
            model.setCpf(entidade.getInstrutor().getCpf());
        }

        if (entidade.getAtividade() != null) {
            model.setNomeAtividade(entidade.getAtividade().getNome());
            model.setDescricao(entidade.getAtividade().getDescricao());
            model.setHorario(entidade.getAtividade().getHorario().toString());
            model.setDuracaoMinutos(entidade.getAtividade().getDuracaoMinutos());
        }

        return model;
    }

    private AtividadeInstrutor toEntity(AtividadeInstrutorModel model) {
        AtividadeInstrutor entidade = new AtividadeInstrutor();
        entidade.setId(model.getId());

        Instrutor instrutor = new Instrutor();
        instrutor.setCpf(model.getCpf());
        instrutor.setNome(model.getNomeInstrutor());
        entidade.setInstrutor(instrutor);
        Atividade atividade = new Atividade();
        atividade.setNome(model.getNomeAtividade());
        atividade.setDescricao(model.getDescricao());
        atividade.setHorario(LocalDateTime.parse(model.getHorario()));
        atividade.setDuracaoMinutos(model.getDuracaoMinutos());
        entidade.setAtividade(atividade);

        return entidade;
    }
}
