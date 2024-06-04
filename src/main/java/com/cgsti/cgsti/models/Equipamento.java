package com.cgsti.cgsti.models;

import jakarta.annotation.Nullable;
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
    @Nullable
    private String numeroSerie;
    @Nullable
    private String marca;
    @Nullable
    private String modelo;
    @Nullable
    private String hdSsd;
    @Nullable
    private String processador;
    @Nullable
    private String placaDeVideo;
    @Nullable
    private String memoriaRam;
    @Nullable
    private String sistemaOperacional;
    @Nullable
    private String arquitetura;
    @Nullable
    private String enderecoMac;
    @Nullable
    private String etiqueta;

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
