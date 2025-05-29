package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "atividade_plano")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AtividadePlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_atividade", nullable = false)
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = false)
    private Plano plano;
}
