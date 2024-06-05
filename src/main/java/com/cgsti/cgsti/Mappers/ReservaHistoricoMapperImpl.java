package com.cgsti.cgsti.Mappers;

import com.cgsti.cgsti.dto.ReservaHistoricoResponseDTO;
import com.cgsti.cgsti.dto.ReservaResponseDTO;
import com.cgsti.cgsti.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ReservaHistoricoMapperImpl implements ReservaHistoricoMapper{



    @Override
    public ReservaHistoricoResponseDTO reservaHistoricoParaReservaResponse(ReservaHistorico reservaHistorico) {
        return new ReservaHistoricoResponseDTO(
                reservaHistorico.getId(),
                reservaHistorico.getResponsavelSetor(),
                reservaHistorico.getDataSolicitacao(),
                reservaHistorico.getDataRetirada(),
                reservaHistorico.getDataEntrega(),
                reservaHistorico.getDataDevolucao(),
                reservaHistorico.getPeriodo(),
                reservaHistorico.getStatusReserva(),
                reservaHistorico.getLocalEvento(),
                reservaHistorico.getTelefone()
        );
    }

    @Override
    public Collection<ReservaHistoricoResponseDTO> reservasHistoricoParaReservasResponse(Collection<ReservaHistorico> reservas) {
        List<ReservaHistoricoResponseDTO> responseDTOList = new ArrayList<>();
        for (ReservaHistorico reserva : reservas) {
            responseDTOList.add(reservaHistoricoParaReservaResponse(reserva));
        }
        return responseDTOList;
    }



}
