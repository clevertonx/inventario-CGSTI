package com.cgsti.cgsti.services;

import com.cgsti.cgsti.Mappers.ReservaHistoricoMapper;
import com.cgsti.cgsti.Mappers.ReservaMapper;
import com.cgsti.cgsti.dto.ReservaHistoricoResponseDTO;
import com.cgsti.cgsti.models.ReservaHistorico;
import com.cgsti.cgsti.repository.ReservaHistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReservaHistoricoService {

    private final ReservaHistoricoRepository reservaHistoricoRepository;
    private final ReservaMapper reservaMapper;
    private final ReservaHistoricoMapper reservaHistoricoMapper;

    public List<ReservaHistoricoResponseDTO> buscarTodasReservasConcluidas() {
        List<ReservaHistorico> reservas = reservaHistoricoRepository.findAll();
        return new ArrayList<>(reservaHistoricoMapper.reservasHistoricoParaReservasResponse(reservas));
    }


    public void excluirHistoricoReserva(Long id) {
        ReservaHistorico reservaHistorico = reservaHistoricoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reserva não encontrada"));


        reservaHistoricoRepository.deleteById(id);
    }

}
