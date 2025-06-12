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
@Table(name = "planos")
public class PlanoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planos_id")
    private int id;
    private String cpf;

    @Column(name = "planos_nome")
    private String nome;

    @Column(name = "planos_tipo")
    private String tipoPlano;

    @Column(name = "planos_periodo_mensalidade")
    int periodoMensalidade;

    @Column(name = "planos_descricao")
    private String descricao;

    @Column(name = "planos_preco")
    private double preco;

    @Column(name = "planos_beneficios")
    String beneficio;


}