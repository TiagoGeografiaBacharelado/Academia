package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente_plano")
public class ClientePlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "id_plano", nullable = false)
    private Long idPlano;

    @Column(name = "id_forma_pagamento", nullable = false)
    private Long idFormaPagamento;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(name = "status_pagamento", length = 50)
    private String statusPagamento;
}