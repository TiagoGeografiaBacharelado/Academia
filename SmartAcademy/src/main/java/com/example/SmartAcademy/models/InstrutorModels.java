package com.example.SmartAcademy.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrutorModel {
    private Long id;
    private String nome;
    private String cpf;
    private String especialidade;
    private String telefone;
    private String email;
}
