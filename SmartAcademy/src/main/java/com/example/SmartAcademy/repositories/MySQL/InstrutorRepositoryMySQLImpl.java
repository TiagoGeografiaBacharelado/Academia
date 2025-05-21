package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.models.InstrutorModels;
import com.example.SmartAcademy.repositories.InstrutorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrutorRepositoryMySQLImpl implements InstrutorRepository {

    private final List<InstrutorModels> instrutores = new ArrayList<>();

    @Override
    public void adicionar(InstrutorModels instrutor) {
        instrutores.add(instrutor);
    }

    @Override
    public void atualizar(InstrutorModels instrutor) {
        for (int i = 0; i < instrutores.size(); i++) {
            if (instrutores.get(i).getId() == instrutor.getId()) {
                instrutores.set(i, instrutor);
                break;
            }
        }
    }

    @Override
    public void remover(int codigo) {
        instrutores.removeIf(instrutor -> instrutor.getId() == codigo);
    }

    @Override
    public List<InstrutorModels> buscar() {
        return new ArrayList<>(instrutores); // retorno seguro
    }

    @Override
    public InstrutorModels buscarPorCodigo(int codigo) {
        return instrutores.stream()
                .filter(instrutor -> instrutor.getId() == codigo)
                .findFirst()
                .orElse(null);
    }
}
