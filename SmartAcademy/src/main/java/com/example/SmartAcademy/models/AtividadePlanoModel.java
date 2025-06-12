package com.example.SmartAcademy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atividade_plano")
public class AtividadePlanoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_plano_id")
    private int id;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "atividade_id", referencedColumnName = "atividade_id")
    private AtividadeModel atividade;

    @ManyToOne
    @JoinColumn(name = "plano_id", referencedColumnName = "planos_id")
    private PlanoModel plano;

    @Column(name = "atividade_plano_observacao")
    private String observacao;



}
