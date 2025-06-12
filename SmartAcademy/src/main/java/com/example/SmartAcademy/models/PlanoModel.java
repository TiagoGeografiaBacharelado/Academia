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
public class PlanoModel {
    private int id;
    private String cpf;

    private String nome;

    private String tipoPlano;

    int periodoMensalidade;

    private String descricao;

    private double preco;

    String beneficio;


}