package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.Cliente;
import com.example.SmartAcademy.models.ClienteModel;
import com.example.SmartAcademy.repositories.jpa.ClienteJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteInterfaceMySQLImpl implements com.example.SmartAcademy.interfaces.ClienteRepository {

    private final ClienteJPA clienteJPA;

    @Autowired
    public ClienteInterfaceMySQLImpl(ClienteJPA clienteJPA) {
        this.clienteJPA = clienteJPA;
    }

    @Override
    public Optional<ClienteModel> buscarPorCodigo(Long id) {
        return clienteJPA.findById(id)
                .map(this::toModel);
    }

    @Override
    public List<ClienteModel> buscarTodos() {
        return clienteJPA.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(ClienteModel dto) {
        Cliente entity = toEntity(dto);
        entity.setId(null);
        clienteJPA.save(entity);
    }

    @Override
    public void atualizar(ClienteModel dto) {
        Cliente entity = toEntity(dto);
        clienteJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        clienteJPA.deleteById(id);
    }

    @Override
    public Optional<ClienteModel> buscarPorCpf(String cpf) {
        return clienteJPA.findByCpf(cpf)
                .map(this::toModel);
    }

    private ClienteModel toModel(Cliente e) {
        return new ClienteModel(
                e.getId(),
                e.getNome(),
                e.getCpf(),
                e.getEndereco(),
                e.getEmail(),
                e.getTelefone(),
                e.getDataNascimento(),
                e.getObservacaoMedica(),
                e.getAltura(),
                e.getPeso()
        );
    }

    private Cliente toEntity(ClienteModel dto) {
        return new Cliente(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                dto.getEndereco(),
                dto.getEmail(),
                dto.getTelefone(),
                dto.getDataNascimento(),
                dto.getObservacaoMedica(),
                dto.getAltura(),
                dto.getPeso()
        );
    }
}