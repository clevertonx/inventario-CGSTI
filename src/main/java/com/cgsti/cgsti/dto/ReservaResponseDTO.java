package com.cgsti.cgsti.dto;

import com.cgsti.cgsti.models.Periodo;
import com.cgsti.cgsti.models.StatusReserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaResponseDTO {

    private long id;
    private String responsavelSetor;
    private LocalDate dataSolicitacao;
    private LocalDate dataRetirada;
    private LocalDate dataEntrega;
    private LocalDate dataDevolucao;
    private Periodo periodo;
    private StatusReserva statusReserva;
    private String localEvento;
    private String telefone;
    private List<Long> equipamentosIds;

}
