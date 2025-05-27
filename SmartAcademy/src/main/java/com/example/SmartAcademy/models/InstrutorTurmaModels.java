package com.example.SmartAcademy.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrutorTurmaModel {
    private Long id;
    private Long instrutorId;
    private Long turmaId;
}
