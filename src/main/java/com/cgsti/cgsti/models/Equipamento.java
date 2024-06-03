package com.cgsti.cgsti.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;

    @Enumerated(EnumType.STRING)
    private StatusEquipamento status;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = true)
    private Reserva reserva;

    public Equipamento(String nome, String tipo, StatusEquipamento status) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
    }
}
