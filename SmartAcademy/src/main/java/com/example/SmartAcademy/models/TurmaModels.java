package com.example.SmartAcademy.models;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurmaModel {
    private Long id;
    private LocalDateTime horario;
    private Long atividadeId; // Relacionamento com entidade Atividade (se existir)
    private Long salaId;
}
