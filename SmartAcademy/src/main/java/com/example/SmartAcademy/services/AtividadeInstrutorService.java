package com.example.SmartAcademy.services; // Pacote de serviços

import com.example.SmartAcademy.interfaces.AtividadeInstrutorRepository; // Importa interface de repositório
import com.example.SmartAcademy.models.AtividadeInstrutorModel; // Importa modelo DTO
import org.springframework.beans.factory.annotation.Autowired; // Injeta dependências
import org.springframework.stereotype.Service; // Marca como serviço
import org.springframework.transaction.annotation.Transactional; // Transações

import java.util.List; // Listagem
import java.util.Optional; // Optional

@Service // Define bean de serviço
@Transactional // Gerencia transações automaticamente
public class AtividadeInstrutorService { // Classe de serviço

    private final AtividadeInstrutorRepository atividadeInstrutorRepository;

    @Autowired // Injeta via construtor
    public AtividadeInstrutorService(AtividadeInstrutorRepository atividadeInstrutorRepository) {
        this.atividadeInstrutorRepository = atividadeInstrutorRepository; // Atribuição
    }

    public List<AtividadeInstrutorModel> listarTodos() { // Lista todos clientes
        return atividadeInstrutorRepository.buscarTodos(); // Delegação
    }

    public Optional<AtividadeInstrutorModel> buscarPorId(int id) { // Busca por ID
        return atividadeInstrutorRepository.buscarPorCodigo(id); // Delegação
    }

    public AtividadeInstrutorModel criar(AtividadeInstrutorModel dto) { // Cria novo cliente
        if (atividadeInstrutorRepository.buscarPorCpf(dto.getCpf()).isPresent()) { // Verifica CPF duplicado
            throw new IllegalArgumentException("CPF já cadastrado: " + dto.getCpf()); // Exceção
        }
        atividadeInstrutorRepository.adicionar(dto); // Persiste
        return dto; // Retorna DTO (poderia buscar ID atualizado)
    }

    public AtividadeInstrutorModel atualizar(int id, AtividadeInstrutorModel dto) { // Atualiza cliente existente
        Optional<AtividadeInstrutorModel> existente = atividadeInstrutorRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("atividade não encontrado com ID: " + id); // Erro
        }
        dto.setId(id); // Atribui ID ao DTO
        atividadeInstrutorRepository.atualizar(dto); // Persiste atualização
        return dto; // Retorna DTO
    }

    public void deletar(int id) { // Deleta cliente
        Optional<AtividadeInstrutorModel> existente = atividadeInstrutorRepository.buscarPorCodigo(id); // Verifica existência
        if (existente.isEmpty()) { // Se não existe
            throw new IllegalArgumentException("atividade não encontrado com ID: " + id); // Erro
        }
        atividadeInstrutorRepository.remover(id); // Remove
    }

}
