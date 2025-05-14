package main.java.com.example.SmartAcademy.Interfaces;

import com.example.SmartAcademy.models.ClienteModels;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteModels> buscarPorCodigo(Integer id);
    List<ClienteModels> buscarTodos();
    void adicionar(ClienteModels cliente);
    void remover(Integer id);
    void atualizar(ClienteModels cliente);
    Optional<ClienteModels> buscarPorCpf(String cpf);
}