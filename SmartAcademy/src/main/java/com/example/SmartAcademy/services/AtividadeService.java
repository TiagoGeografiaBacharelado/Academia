package com.example.SmartAcademy.services; // Pacote de serviços

import com.example.SmartAcademy.interfaces.AtividadeRepository; // Importa interface de repositório
import com.example.SmartAcademy.models.AtividadeModel; // Importa modelo DTO
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.stereotype.Service; // Marca como serviço
import org.springframework.transaction.annotation.Transactional; // Transações

import java.util.List; // Listagem
import java.util.Optional; // Optional

@Service // Define bean de serviço
@Transactional // Gerencia transações automaticamente
public class AtividadeService { // Classe de serviço

    private final AtividadeRepository atividadeRepository; // Dependência do repositório

    @Autowired // Injeta via construtor
    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository; // Atribuição
    }

    public List<AtividadeModel> listarTodos() { // Lista todos clientes
        return atividadeRepository.buscarTodos(); // Delegação
    }

    public Optional<Optional<AtividadeModel>> buscarPorId(int id) { // Busca por ID
        return Optional.ofNullable(atividadeRepository.buscarPorCodigo(id)); // Delegação
    }

    public AtividadeModel atualizar(int id, AtividadeModel dto) { // Atualiza cliente existente
        Optional<Optional<AtividadeModel>> existente = Optional.ofNullable(atividadeRepository.buscarPorCodigo(id)); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Plano não encontrado com ID: " + id); // Erro
        }
        dto.setId(id); // Atribui ID ao DTO
        atividadeRepository.atualizar(dto); // Persiste atualização
        return dto; // Retorna DTO
    }


    public void deletar(int id) { // Deleta cliente
        Optional<Optional<AtividadeModel>> existente = Optional.ofNullable(atividadeRepository.buscarPorCodigo(id)); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Plano não encontrado com ID: " + id); // Erro
        }
        atividadeRepository.remover(id); // Remove
    }

}