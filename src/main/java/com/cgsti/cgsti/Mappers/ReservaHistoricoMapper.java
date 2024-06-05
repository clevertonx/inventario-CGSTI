package com.cgsti.cgsti.Mappers;

import com.cgsti.cgsti.dto.ReservaHistoricoResponseDTO;
import com.cgsti.cgsti.dto.ReservaResponseDTO;
import com.cgsti.cgsti.models.Reserva;
import com.cgsti.cgsti.models.ReservaHistorico;

import java.util.Collection;

public interface ReservaHistoricoMapper {

    ReservaHistoricoResponseDTO reservaHistoricoParaReservaResponse(ReservaHistorico reservaHistorico);

    Collection<ReservaHistoricoResponseDTO> reservasHistoricoParaReservasResponse(Collection<ReservaHistorico> reservas);


}
