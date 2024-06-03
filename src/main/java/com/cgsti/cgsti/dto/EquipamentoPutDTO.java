package com.cgsti.cgsti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoPutDTO {

    private Long id;
    private String nome;
    private String tipo;
}
