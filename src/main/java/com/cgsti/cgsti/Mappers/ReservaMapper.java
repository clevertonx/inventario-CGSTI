package com.cgsti.cgsti.Mappers;

import com.cgsti.cgsti.dto.EquipamentoReservaResponseDTO;
import com.cgsti.cgsti.dto.ReservaRequestDTO;
import com.cgsti.cgsti.dto.ReservaResponseDTO;
import com.cgsti.cgsti.models.Reserva;
import com.cgsti.cgsti.models.ReservaHistorico;

import java.util.Collection;
import java.util.List;

public interface ReservaMapper {

    Reserva reservaRequestParaReserva(ReservaRequestDTO reservaRequestDTO);

    ReservaResponseDTO reservaParaReservaResponse(Reserva reserva);

    Collection<ReservaResponseDTO> reservasParaReservasResponse(List<Reserva> reservas);

    Collection<EquipamentoReservaResponseDTO> reservasParaReservasEquipamentoResponse(Collection<Reserva> reservas);

}
