package com.example.SmartAcademy.models;

import jakarta.persistence.*; // Apenas se estiver usando a mesma tabela, senão remova @Entity
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AtividadeInstrutorModel {

    private long id;


    private String nomeAtividade;


    private String cpf;


    private String nomeInstrutor;


    private String horario;


    private String descricao;

    private int duracaoMinutos;
}
