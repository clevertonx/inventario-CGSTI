package com.cgsti.cgsti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoRequestDTO {

    private String nome;
    private String tipo;
    private String numeroSerie;
    private String marca;
    private String modelo;
    private String hdSsd;
    private String processador;
    private String placaDeVideo;
    private String memoriaRam;
    private String sistemaOperacional;
    private String arquitetura;
    private String enderecoMac;
    private String etiqueta;
}
