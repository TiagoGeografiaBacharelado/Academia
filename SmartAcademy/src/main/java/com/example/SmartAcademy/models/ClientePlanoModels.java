package com.example.SmartAcademy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente_plano")
public class ClientePlanoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_cliente", nullable = false)
    private int clienteId;

    @Column(name = "id_plano", nullable = false)
    private int planoId;

    @Column(name = "id_pagamento")
    private int pagamentoId;

    @Column(name = "data_validade")
    private LocalDateTime dataValidade;
}