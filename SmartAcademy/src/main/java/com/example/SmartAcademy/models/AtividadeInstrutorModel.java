package com.example.SmartAcademy.models;

import jakarta.persistence.*; // Apenas se estiver usando a mesma tabela, senão remova @Entity
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atividade_instrutor")
public class AtividadeInstrutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instrutor") // Este nome deve bater com a chave primária da tabela, mas o ideal é ser "id"
    private long id;

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
