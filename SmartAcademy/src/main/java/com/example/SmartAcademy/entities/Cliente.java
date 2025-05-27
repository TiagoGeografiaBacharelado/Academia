package com.example.SmartAcademy.entities; // Pacote de entidades JPA

import jakarta.persistence.*; // Anotações JPA via Jakarta
import lombok.*; // Lombok para getters/setters
import java.time.LocalDate; // Tipo LocalDate para datas sem hora
import java.time.LocalDateTime;

@Entity // Marca como entidade JPA
@Table(name = "clientes") // Mapeia tabela 'clientes'
@Getter @Setter @NoArgsConstructor @AllArgsConstructor // Lombok gera métodos
public class Cliente { // Classe de entidade Cliente
    @Id // Define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento
    private Long id; // Identificador único

    @Column(nullable = false, length = 100) // Nome obrigatório, tamanho até 100
    private String nome; // Nome do cliente

    @Column(unique = true, nullable = false, length = 11) // CPF único, obrigatório
    private String cpf; // CPF do cliente

    @Column(length = 200) // Endereço opcional, até 200 chars
    private String endereco; // Endereço residencial

    @Column(length = 100) // Email opcional, até 100 chars
    private String email; // Email de contato

    @Column(length = 20) // Telefone opcional, até 20 chars
    private String telefone; // Telefone de contato

    @Column(name = "data_nascimento") // Coluna personalizada
    private LocalDateTime dataNascimento; // Data de nascimento sem hora

    @Column(name = "observacao_medica", columnDefinition = "TEXT") // Texto longo
    private String observacaoMedica; // Observações médicas

    @Column // Altura opcional
    private Float altura; // Altura em metros

    @Column // Peso opcional
    private Float peso; // Peso em kg

}