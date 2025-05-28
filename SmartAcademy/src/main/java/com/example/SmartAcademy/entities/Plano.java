package com.example.SmartAcademy.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "planos") // Tabela para armazenar os planos da academia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "duracao_meses", nullable = false)
    private Integer duracaoMeses;

    @Column(columnDefinition = "TEXT")
    private String descricao;

}
