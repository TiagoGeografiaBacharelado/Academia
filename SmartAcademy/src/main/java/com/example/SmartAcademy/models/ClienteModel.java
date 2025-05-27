package com.example.SmartAcademy.models;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDateTime dataNascimento;
    private String observacaoMedica;
    private Float altura;
    private Float peso;
}