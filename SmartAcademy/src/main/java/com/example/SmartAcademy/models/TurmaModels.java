package com.example.SmartAcademy.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turma")
public class TurmaModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private int id;

    @Column(name = "id_atividade")
    private int idAtividade;

    @Column(name = "horario")
    private String horario;

    @Column(name = "Sala_id_sala")
    private int idSala;
}
