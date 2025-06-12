package com.example.SmartAcademy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AtividadeModel {

    private int id;

    private String nome;

    private String descricao;

    private int duracaoMinutos;

    private String nivel;

    private String tipo;
}