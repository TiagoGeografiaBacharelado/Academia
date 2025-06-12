package com.example.SmartAcademy.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientePlanoModel {
    private Long id;
    private Long idCliente;
    private Long idPlano;
    private Long idFormaPagamento;
    private LocalDate dataValidade;
    private String statusPagamento;
}