package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sala")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer capacidade;
}