package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instrutor_turma")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class InstrutorTurma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_instrutor", nullable = false)
    private Instrutor instrutor;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;
}
