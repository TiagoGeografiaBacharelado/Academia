package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "atividade_instrutor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeInstrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_atividade", nullable = false)
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "id_instrutor", nullable = false)
    private Instrutor instrutor;

    public int getInstrutorId() {
        return instrutor.getId();
    }

    public String getInstrutorNome() {
        return instrutor.getNome();
    }

    public String getInstrutorCpf() {
        return instrutor.getCpf();
    }

    public String getInstrutorEndereco() {
        return instrutor.getEndereco();
    }

    public String getInstrutorEmail() {
        return instrutor.getEmail();
    }

    public String getInstrutorTelefone() {
        return instrutor.getTelefone();
    }

    public String getInstrutorDataNascimento() {
        return instrutor.getDataNascimento();
    }
}
