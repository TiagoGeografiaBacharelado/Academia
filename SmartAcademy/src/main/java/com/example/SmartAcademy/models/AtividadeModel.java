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
@Table(name = "atividades")
public class AtividadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_id")
    private int id;

    @Column(name = "atividade_nome")
    private String nome;

    @Column(name = "atividade_descricao")
    private String descricao;

    @Column(name = "atividade_duracao_minutos")
    private int duracaoMinutos;

    @Column(name = "atividade_nivel")
    private String nivel;  // Ex: Iniciante, Intermediário, Avançado

    @Column(name = "atividade_tipo")
    private String tipo;   // Ex: Aeróbica, Musculação, Funcional, etc.
}
