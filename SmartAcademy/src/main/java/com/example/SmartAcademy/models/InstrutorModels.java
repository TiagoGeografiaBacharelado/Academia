package com.example.SmartAcademy.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instrutores")
public class InstrutorModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instrutor")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "certificado")
    private String certificado;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;
}
