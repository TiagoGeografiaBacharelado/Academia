package com.example.SmartAcademy.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sala")
public class SalaModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "capacidade")
    private int capacidade;
}
