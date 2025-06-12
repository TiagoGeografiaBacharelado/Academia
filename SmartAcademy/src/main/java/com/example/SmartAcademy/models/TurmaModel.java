package com.example.SmartAcademy.models;

import lombok.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurmaModel {

    private Long idTurma;
    private LocalTime horario;
    private Long idSala;
}