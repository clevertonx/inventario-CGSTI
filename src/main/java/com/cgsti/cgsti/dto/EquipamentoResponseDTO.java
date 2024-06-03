package com.cgsti.cgsti.dto;

import com.cgsti.cgsti.models.StatusEquipamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipamentoResponseDTO {

    private long id;
    private String nome;
    private String tipo;
    private StatusEquipamento statusEquipamento;
}
