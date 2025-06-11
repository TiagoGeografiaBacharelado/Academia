package com.example.SmartAcademy.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrutorTurmaModel {
    private Long id;
    private Long idInstrutor;
    private Long idTurma;
}