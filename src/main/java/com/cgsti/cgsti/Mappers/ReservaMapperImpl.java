package com.cgsti.cgsti.Mappers;

import com.cgsti.cgsti.dto.EquipamentoReservaResponseDTO;
import com.cgsti.cgsti.dto.ReservaRequestDTO;
import com.cgsti.cgsti.dto.ReservaResponseDTO;
import com.cgsti.cgsti.models.Equipamento;
import com.cgsti.cgsti.models.Reserva;
import com.cgsti.cgsti.repository.EquipamentoRepository;
import com.cgsti.cgsti.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservaMapperImpl implements ReservaMapper{

    @Autowired
    private EquipamentoRepository equipamentoRepository;
    @Override
    public Reserva reservaRequestParaReserva(ReservaRequestDTO reservaRequestDTO) {
        List<Equipamento> equipamentos = reservaRequestDTO.getEquipamentosIds().stream()
                .map(id -> equipamentoRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Equipamento não encontrado com o ID: " + id)))
                .collect(Collectors.toList());

        return new Reserva(
                reservaRequestDTO.getResponsavelSetor(),
                reservaRequestDTO.getDataSolicitacao(),
                reservaRequestDTO.getDataRetirada(),
                reservaRequestDTO.getDataEntrega(),
                reservaRequestDTO.getPeriodo(),
                reservaRequestDTO.getLocalEvento(),
                reservaRequestDTO.getTelefone(),
                equipamentos
        );
    }


    @Override
    public ReservaResponseDTO reservaParaReservaResponse(Reserva reserva) {
        List<Long> equipamentosIds = reserva.getEquipamentos().stream()
                .map(Equipamento::getId)
                .collect(Collectors.toList());

        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getResponsavelSetor(),
                reserva.getDataSolicitacao(),
                reserva.getDataRetirada(),
                reserva.getDataEntrega(),
                reserva.getPeriodo(),
                reserva.getLocalEvento(),
                reserva.getTelefone(),
                equipamentosIds
        );
    }


    @Override
    public Collection<ReservaResponseDTO> reservasParaReservasResponse(Collection<Reserva> reservas) {
        Collection<ReservaResponseDTO> reservasMapeadas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            reservasMapeadas.add(reservaParaReservaResponse(reserva));
        }
        return reservasMapeadas;

    }

    @Override
    public Collection<EquipamentoReservaResponseDTO> reservasParaReservasEquipamentoResponse(Collection<Reserva> reservas) {
        Collection<EquipamentoReservaResponseDTO> reservasMapeadas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            List<Long> equipamentoIds = new ArrayList<>();
            for (Equipamento equipamento : reserva.getEquipamentos()) {
                equipamentoIds.add(equipamento.getId());
            }

            reservasMapeadas.add(new EquipamentoReservaResponseDTO(
                    reserva.getId(),
                    reserva.getResponsavelSetor(),
                    reserva.getDataSolicitacao(),
                    reserva.getDataRetirada(),
                    reserva.getDataEntrega(),
                    reserva.getPeriodo(),
                    reserva.getLocalEvento(),
                    reserva.getTelefone(),
                    equipamentoIds
            ));
        }
        return reservasMapeadas;
    }



}
