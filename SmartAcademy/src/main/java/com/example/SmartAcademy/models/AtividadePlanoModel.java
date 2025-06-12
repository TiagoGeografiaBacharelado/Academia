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
public class AtividadePlanoModel {

    private int id;
    private String cpf;

    private AtividadeModel atividade;

    private PlanoModel plano;

    private String observacao;



}
