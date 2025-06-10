package com.example.SmartAcademy.models;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrutorModel {
    private Long idInstrutor;
    private String nome;
    private String cpf;
    private String certificado;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
}
