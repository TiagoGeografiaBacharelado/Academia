package com.example.SmartAcademy.models;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurmaModel {
    private Long id;
    private String nome;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private Long salaId;
}
