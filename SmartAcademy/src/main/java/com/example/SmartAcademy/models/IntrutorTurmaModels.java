package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instrutorturma")
public class InstrutorTurmaModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_instrutor")
    private int idInstrutor;

    @Column(name = "id_turma")
    private int idTurma;

    @Column(name = "Cliente_id_cliente")
    private int idCliente;
}
