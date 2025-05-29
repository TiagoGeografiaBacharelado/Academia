package com.example.SmartAcademy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atividade_instrutor")
public class AtividadeInstrutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instrutor_id")
    private int id;

    @Column(name = "atividade_nome")
    private String nomeAtividade;

    @Column(name = "atividade_cpf")
    private String cpf;

    @Column(name = "instrutor_nome")
    private String nomeInstrutor;

    @Column(name = "atividade_horario")
    private String horario;

    @Column(name = "atividade_descricao")
    private String descricao;

    @Column(name = "atividade_duracao_minutos")
    private int duracaoMinutos;
}
