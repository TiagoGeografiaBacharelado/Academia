package com.example.SmartAcademy.services; // Pacote de serviços

import com.example.SmartAcademy.interfaces.ClienteRepository; // Importa interface de repositório
import com.example.SmartAcademy.models.ClienteModel; // Importa modelo DTO
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.stereotype.Service; // Marca como serviço
import org.springframework.transaction.annotation.Transactional; // Transações

import java.util.List; // Listagem
import java.util.Optional; // Optional

@Service // Define bean de serviço
@Transactional // Gerencia transações automaticamente
public class ClienteService { // Classe de serviço

    private final ClienteRepository clienteRepository; // Dependência do repositório

    @Autowired // Injeta via construtor
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository; // Atribuição
    }

    public List<ClienteModel> listarTodos() { // Lista todos clientes
        return clienteRepository.buscarTodos(); // Delegação
    }

    public Optional<ClienteModel> buscarPorId(Long id) { // Busca por ID
        return clienteRepository.buscarPorCodigo(id); // Delegação
    }

    public ClienteModel criar(ClienteModel dto) { // Cria novo cliente
        if (clienteRepository.buscarPorCpf(dto.getCpf()).isPresent()) { // Verifica CPF duplicado
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf()); // Exceção
        }
        clienteRepository.adicionar(dto); // Persiste
        return dto; // Retorna DTO (poderia buscar ID atualizado)
    }

    public ClienteModel atualizar(Long id, ClienteModel dto) { // Atualiza cliente existente
        Optional<ClienteModel> existente = clienteRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id); // Erro
        }
        dto.setId(id); // Atribui ID ao DTO
        clienteRepository.atualizar(dto); // Persiste atualização
        return dto; // Retorna DTO
    }

    public void deletar(Long id) { // Deleta cliente
        Optional<ClienteModel> existente = clienteRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id); // Erro
        }
        clienteRepository.remover(id); // Remove
    }

}
