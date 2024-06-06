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
}
