package com.cgsti.cgsti.dto;

import com.cgsti.cgsti.models.Periodo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequestDTO {

    private String responsavelSetor;
    private LocalDate dataSolicitacao;
    private LocalDate dataRetirada;
    private LocalDate dataEntrega;
    private Periodo periodo;
    private String localEvento;
    private String telefone;
    List<Long> equipamentosIds;


}
