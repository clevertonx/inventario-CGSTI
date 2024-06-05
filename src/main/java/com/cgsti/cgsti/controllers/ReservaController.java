package com.cgsti.cgsti.controllers;

import com.cgsti.cgsti.dto.ReservaPutDTO;
import com.cgsti.cgsti.dto.ReservaRequestDTO;
import com.cgsti.cgsti.dto.ReservaResponseDTO;
import com.cgsti.cgsti.services.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservaController {

    private final ReservaService reservaService;

    @Operation(summary = "Busca todas as reservas cadastradas")
    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> findAll() {
        return ResponseEntity.ok(reservaService.buscarTodasReservas());
    }

    @Operation(summary = "Busca reserva por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> findById(@PathVariable Long id) {
        ReservaResponseDTO reserva = reservaService.buscarReservaPorId(id);
        if (reserva == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reserva);
    }

    @Operation(summary = "Cadastra uma nova reserva")
    @PostMapping
    public ResponseEntity<ReservaResponseDTO> save(@RequestBody ReservaRequestDTO reservaRequestDTO) {
        ReservaResponseDTO reserva = reservaService.cadastrarReserva(reservaRequestDTO);
        return ResponseEntity.status(201).body(reserva);
    }

    @Operation(summary = "Altera uma reserva")
    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<ReservaResponseDTO> atualizarReserva(@RequestBody ReservaPutDTO reservaPutDTO,
                                                               @PathVariable Long id) {

        return ResponseEntity.ok(reservaService.atualizarReserva(reservaPutDTO, id));
    }

    @Operation(summary = "Conclui uma reserva pelo ID")
    @PutMapping("/concluir/{id}")
    public ResponseEntity<ReservaResponseDTO> concluirReserva(@PathVariable Long id) {
        ReservaResponseDTO response = reservaService.concluirReserva(id);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Deleta uma reserva")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        reservaService.excluirReserva(id);
        return ResponseEntity.noContent().build();
    }
}
