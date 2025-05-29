package com.example.SmartAcademy.services; // Pacote de serviços

import com.example.SmartAcademy.interfaces.AtividadePlanoRepository; // Importa interface de repositório
import com.example.SmartAcademy.models.AtividadePlanoModel; // Importa modelo DTO
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.stereotype.Service; // Marca como serviço
import org.springframework.transaction.annotation.Transactional; // Transações

import java.util.List; // Listagem
import java.util.Optional; // Optional

@Service // Define bean de serviço
@Transactional // Gerencia transações automaticamente
public class AtividadePlanoService { // Classe de serviço

    private final AtividadePlanoRepository atividadePlanoRepository; // Dependência do repositório

    @Autowired // Injeta via construtor
    public AtividadePlanoService(AtividadePlanoRepository atividadePlanoRepository) {
        this.atividadePlanoRepository = atividadePlanoRepository; // Atribuição
    }

    public List<AtividadePlanoModel> listarTodos() { // Lista todos clientes
        return atividadePlanoRepository.buscarTodos(); // Delegação
    }

    public Optional<Optional<AtividadePlanoModel>> buscarPorId(int id) { // Busca por ID
        return Optional.ofNullable(atividadePlanoRepository.buscarPorCodigo(id)); // Delegação
    }


    public AtividadePlanoModel atualizar(int id, AtividadePlanoModel dto) { // Atualiza cliente existente
        Optional<AtividadePlanoModel> existente = atividadePlanoRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id); // Erro
        }
        dto.setId(id); // Atribui ID ao DTO
        atividadePlanoRepository.atualizar(dto); // Persiste atualização
        return dto; // Retorna DTO
    }

    public AtividadePlanoModel criar(AtividadePlanoModel dto) { // Cria novo cliente
        if (atividadePlanoRepository.buscarPorCpf(dto.getCpf()).isPresent()) { // Verifica CPF duplicado
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf()); // Exceção
        }
        atividadePlanoRepository.adicionar(dto); // Persiste
        return dto; // Retorna DTO (poderia buscar ID atualizado)
    }

    public void deletar(int id) { // Deleta cliente
        Optional<AtividadePlanoModel> existente = atividadePlanoRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id); // Erro
        }
        atividadePlanoRepository.remover(id); // Remove
    }


}
