package com.cgsti.cgsti.dto;

import com.cgsti.cgsti.models.TipoEquipamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoPutDTO {

    private Long id;
    private String nome;
    private TipoEquipamento tipoEquipamento;
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
