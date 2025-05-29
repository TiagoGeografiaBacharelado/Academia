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
}
