package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.interfaces.InstrutorRepository;
import com.geriaTeam.geriatricare.models.InstrutorModels;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrutorRepositoryMySQLImpl implements InstrutorRepository {

    private List<InstrutorModels> instrutores = new ArrayList<>();

    @Override
    public void adicionar(InstrutorModels instrutor) {
        instrutores.add(instrutor);
    }

    @Override
    public void atualizar(InstrutorModels instrutor) {
        for (int i = 0; i < instrutores.size(); i++) {
            if (instrutores.get(i).getCodigo() == instrutor.getCodigo()) {
                instrutores.set(i, instrutor);
                break;
            }
        }
    }

    @Override
    public void remover(int codigo) {
        instrutores.removeIf(instrutor -> instrutor.getCodigo() == codigo);
    }

    @Override
    public List<InstrutorModels> buscar() {
        return instrutores;
    }

    @Override
    public InstrutorModels buscarPorCodigo(int codigo) {
        return instrutores.stream()
                .filter(instrutor -> instrutor.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }
}
