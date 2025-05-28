package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "turmas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long id;

    @Column(name = "horario_time")
    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "id_atividade")
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "Sala_id_sala")
    private Sala sala;
}
