package com.cgsti.cgsti.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responsavelSetor;
    private LocalDate dataSolicitacao;
    private LocalDate dataRetirada;
    private LocalDate dataEntrega;
    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    private Periodo periodo;
    @Enumerated(EnumType.STRING)
    private StatusReserva statusReserva;

    private String localEvento;
    private String telefone;

}
