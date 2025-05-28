package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instrutorturma")
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

    @Column(name = "Cliente_id_cliente")
    private Long clienteId;
}
