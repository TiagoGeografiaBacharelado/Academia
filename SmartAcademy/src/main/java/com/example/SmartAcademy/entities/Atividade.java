package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "atividades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(name = "duracao_minutos")
    private int duracaoMinutos;

    @Column(name = "horario", nullable = true)
    private LocalDateTime horario;
}

