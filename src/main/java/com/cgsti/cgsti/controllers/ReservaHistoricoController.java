package com.cgsti.cgsti.controllers;

import com.cgsti.cgsti.dto.ReservaHistoricoResponseDTO;
import com.cgsti.cgsti.dto.ReservaResponseDTO;
import com.cgsti.cgsti.services.ReservaHistoricoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservaHistorico")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservaHistoricoController {

    private final ReservaHistoricoService reservaHistoricoService;

    @Operation(summary = "Busca todas as reservas concluidas")
    @GetMapping
    public ResponseEntity<List<ReservaHistoricoResponseDTO>> findAll() {
        return ResponseEntity.ok(reservaHistoricoService.buscarTodasReservasConcluidas());
    }

    @Operation(summary = "Deleta uma reserva do histórico")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservaHistoricoService.excluirHistoricoReserva(id);
    }
}

