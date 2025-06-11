package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Plano;
import com.example.SmartAcademy.interfaces.PlanoRepository;
import com.example.SmartAcademy.models.PlanoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class AtividadeMySQLImpl implements PlanoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PlanoModel> buscarTodos() {
        List<Plano> planos = entityManager.createQuery("SELECT p FROM Plano p", Plano.class).getResultList();
        return planos.stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<PlanoModel> buscarPorCodigo(int id) {
        Plano plano = entityManager.find(Plano.class, id);
        return plano != null ? Optional.of(toModel(plano)) : Optional.empty();
    }

    @Override
    public Optional<PlanoModel> buscarPorCpf(String cpf) {
        List<Plano> resultados = entityManager.createQuery(
                        "SELECT p FROM Plano p WHERE p.descricao LIKE :cpf", Plano.class)
                .setParameter("cpf", "%" + cpf + "%") // Exemplo: filtro fictício
                .getResultList();

        return resultados.isEmpty() ? Optional.empty() : Optional.of(toModel(resultados.get(0)));
    }

    @Override
    public void adicionar(PlanoModel dto) {
        Plano plano = toEntity(dto);
        entityManager.persist(plano);
    }

    @Override
    public void atualizar(PlanoModel dto) {
        Plano plano = toEntity(dto);
        entityManager.merge(plano);
    }

    @Override
    public void remover(int id) {
        Plano plano = entityManager.find(Plano.class, id);
        if (plano != null) {
            entityManager.remove(plano);
        }
    }

    private PlanoModel toModel(Plano plano) {
        PlanoModel model = new PlanoModel();
        model.setId(plano.getId());
        model.setNome(plano.getNome());
        model.setDescricao(plano.getDescricao());
        return model;
    }


    private Plano toEntity(PlanoModel model) {
        Plano plano = new Plano();
        plano.setId(model.getId());
        plano.setNome(model.getNome());
        plano.setDescricao(model.getDescricao());
        return plano;
    }
}
