package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "atividade_plano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtividadePlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "atividade_id", nullable = false)
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;

    @Column(nullable = false, length = 14) // CPF formatado: 000.000.000-00
    private String cpf;
}
