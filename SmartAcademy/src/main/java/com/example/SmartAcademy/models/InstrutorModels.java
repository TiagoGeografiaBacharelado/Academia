package com.example.SmartAcademy.models;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrutorModel {
    private Long id;
    private String nome;
    private String cpf;
    private String certificado;
    private String email;
    private String telefone;
    private LocalDateTime dataNascimento;
    private String endereco;
}
