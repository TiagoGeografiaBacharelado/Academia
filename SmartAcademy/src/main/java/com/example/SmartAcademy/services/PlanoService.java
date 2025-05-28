package com.example.SmartAcademy.services; // Pacote de serviços

import com.example.SmartAcademy.interfaces.PlanoRepository; // Importa interface de repositório
import com.example.SmartAcademy.models.PlanoModel; // Importa modelo DTO
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.stereotype.Service; // Marca como serviço
import org.springframework.transaction.annotation.Transactional; // Transações

import java.util.List; // Listagem
import java.util.Optional; // Optional

@Service // Define bean de serviço
@Transactional // Gerencia transações automaticamente
public class PlanoService { // Classe de serviço

    private final PlanoRepository planoRepository; // Dependência do repositório

    @Autowired // Injeta via construtor
    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository; // Atribuição
    }

    public List<PlanoModel> listarTodos() { // Lista todos clientes
        return planoRepository.buscarTodos(); // Delegação
    }

    public Optional<PlanoModel> buscarPorId(Long id) { // Busca por ID
        return planoRepository.buscarPorCodigo(id); // Delegação
    }

    public PlanoModel criar(PlanoModel dto) { // Cria novo cliente
        if (planoRepository.buscarPorCpf(dto.getCpf()).isPresent()) { // Verifica CPF duplicado
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf()); // Exceção
        }
        planoRepository.adicionar(dto); // Persiste
        return dto; // Retorna DTO (poderia buscar ID atualizado)
    }

    public PlanoModel atualizar(Long id, PlanoModel dto) { // Atualiza cliente existente
        Optional<PlanoModel> existente = planoRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id); // Erro
        }
        dto.setId(id); // Atribui ID ao DTO
        planoRepository.atualizar(dto); // Persiste atualização
        return dto; // Retorna DTO
    }

    public void deletar(Long id) { // Deleta cliente
        Optional<PlanoModel> existente = planoRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id); // Erro
        }
        planoRepository.remover(id); // Remove
    }

}
