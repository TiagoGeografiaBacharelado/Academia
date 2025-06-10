package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "instrutor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstrutor;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 45)
    private String cpf;

    @Column(length = 45)
    private String certificado;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
}
