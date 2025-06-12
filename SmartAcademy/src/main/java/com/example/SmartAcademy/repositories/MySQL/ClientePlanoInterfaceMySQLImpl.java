package com.example.SmartAcademy.repositories.MySQL;

import com.example.SmartAcademy.entities.ClientePlano;
import com.example.SmartAcademy.models.ClientePlanoModel;
import com.example.SmartAcademy.repositories.jpa.ClientePlanoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientePlanoInterfaceMySQLImpl implements com.example.SmartAcademy.interfaces.ClientePlanoRepository {

    private final ClientePlanoJPA clientePlanoJPA;

    @Autowired
    public ClientePlanoInterfaceMySQLImpl(ClientePlanoJPA clientePlanoJPA) {
        this.clientePlanoJPA = clientePlanoJPA;
    }

    @Override
    public Optional<ClientePlanoModel> buscarPorCodigo(Long id) {
        return clientePlanoJPA.findById(id).map(this::toModel);
    }

    @Override
    public List<ClientePlanoModel> buscarTodos() {
        return clientePlanoJPA.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void adicionar(ClientePlanoModel dto) {
        ClientePlano entity = toEntity(dto);
        entity.setId(null);
        clientePlanoJPA.save(entity);
    }

    @Override
    public void atualizar(ClientePlanoModel dto) {
        ClientePlano entity = toEntity(dto);
        clientePlanoJPA.save(entity);
    }

    @Override
    public void remover(Long id) {
        clientePlanoJPA.deleteById(id);
    }

    private ClientePlanoModel toModel(ClientePlano e) {
        return new ClientePlanoModel(
                e.getId(),
                e.getIdCliente(),
                e.getIdPlano(),
                e.getIdFormaPagamento(),
                e.getDataValidade(),
                e.getStatusPagamento()
        );
    }

    private ClientePlano toEntity(ClientePlanoModel dto) {
        return new ClientePlano(
                dto.getId(),
                dto.getIdCliente(),
                dto.getIdPlano(),
                dto.getIdFormaPagamento(),
                dto.getDataValidade(),
                dto.getStatusPagamento()
        );
    }
}