package com.cgsti.cgsti.services;

import com.cgsti.cgsti.Mappers.ReservaMapper;
import com.cgsti.cgsti.dto.ReservaPutDTO;
import com.cgsti.cgsti.dto.ReservaRequestDTO;
import com.cgsti.cgsti.dto.ReservaResponseDTO;
import com.cgsti.cgsti.models.Equipamento;
import com.cgsti.cgsti.models.Reserva;
import com.cgsti.cgsti.models.StatusEquipamento;
import com.cgsti.cgsti.repository.EquipamentoRepository;
import com.cgsti.cgsti.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final EquipamentoRepository equipamentoRepository;

    public List<ReservaResponseDTO> buscarTodasReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return new ArrayList<>(reservaMapper.reservasParaReservasResponse(reservas));
    }

    public ReservaResponseDTO buscarReservaPorId(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::reservaParaReservaResponse)
                .orElse(null);
    }

    @Transactional
    public ReservaResponseDTO cadastrarReserva(ReservaRequestDTO reservaRequestDTO) {
        Reserva reserva = reservaMapper.reservaRequestParaReserva(reservaRequestDTO);
        Reserva savedReserva = reservaRepository.save(reserva);

        List<Equipamento> equipamentos = savedReserva.getEquipamentos();
        for (Equipamento equipamento : equipamentos) {
            equipamento.setStatus(StatusEquipamento.EMPRESTADO);
            equipamentoRepository.save(equipamento);
        }

        return reservaMapper.reservaParaReservaResponse(savedReserva);
    }

    public ReservaResponseDTO atualizarReserva(ReservaPutDTO reservaPutDTO, Long id) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada com o ID: " + id));

        reservaExistente.setResponsavelSetor(reservaPutDTO.getResponsavelSetor());
        reservaExistente.setDataSolicitacao(reservaPutDTO.getDataSolicitacao());
        reservaExistente.setDataRetirada(reservaPutDTO.getDataRetirada());
        reservaExistente.setDataEntrega(reservaPutDTO.getDataEntrega());
        reservaExistente.setPeriodo(reservaPutDTO.getPeriodo());
        reservaExistente.setLocalEvento(reservaPutDTO.getLocalEvento());
        reservaExistente.setTelefone(reservaPutDTO.getTelefone());

        List<Equipamento> equipamentos = equipamentoRepository.findAllById(reservaPutDTO.getEquipamentosIds());
        reservaExistente.setEquipamentos(equipamentos);

        Reserva reservaAtualizada = reservaRepository.save(reservaExistente);

        return reservaMapper.reservaParaReservaResponse(reservaAtualizada);
    }

    @Transactional
    public void excluirReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada com o ID fornecido: " + id));

        for (Equipamento equipamento : reserva.getEquipamentos()) {
            equipamento.setReserva(null);
            equipamento.setStatus(StatusEquipamento.DISPONIVEL);
            equipamentoRepository.save(equipamento);
        }

        reservaRepository.deleteById(id);
    }
}
