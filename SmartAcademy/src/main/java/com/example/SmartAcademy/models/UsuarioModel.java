package com.example.SmartAcademy.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
