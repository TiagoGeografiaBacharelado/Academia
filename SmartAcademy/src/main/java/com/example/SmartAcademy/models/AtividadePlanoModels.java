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
@Table(name = "atividade_plano")
public class AtividadePlanoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_plano_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "atividade_id", referencedColumnName = "atividade_id")
    private AtividadeModels atividade;

    @ManyToOne
    @JoinColumn(name = "plano_id", referencedColumnName = "planos_id")
    private PlanoModels plano;

    @Column(name = "atividade_plano_observacao")
    private String observacao;
}
