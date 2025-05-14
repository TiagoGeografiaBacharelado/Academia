package main.java.com.example.SmartAcademy.Interfaces;

import com.example.SmartAcademy.models.UsuarioModels;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    UsuarioModels buscarPorCodigo(Long id);
    List<UsuarioModels> buscarTodos();
    void adicionar(UsuarioModels usuario);
    void remover(Long id);
    void atualizar(UsuarioModels usuario);
    Optional<UsuarioModels> buscarPorEmail(String email);
}

