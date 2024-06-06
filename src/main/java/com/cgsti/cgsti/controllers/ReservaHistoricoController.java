package com.cgsti.cgsti.controllers;

import com.cgsti.cgsti.Mappers.ReservaHistoricoMapper;
import com.cgsti.cgsti.dto.ReservaHistoricoResponseDTO;
import com.cgsti.cgsti.models.ReservaHistorico;
import com.cgsti.cgsti.repository.ReservaHistoricoRepository;
import com.cgsti.cgsti.services.ReservaHistoricoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservaHistorico")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservaHistoricoController {

    private final ReservaHistoricoRepository reservaHistoricoRepository;
    private final ReservaHistoricoService reservaHistoricoService;
    private final ReservaHistoricoMapper reservaHistoricoMapper;

    @Operation(summary = "Busca todas as reservas concluidas")
    @GetMapping
    public ResponseEntity<List<ReservaHistoricoResponseDTO>> findAll() {
        return ResponseEntity.ok(reservaHistoricoService.buscarTodasReservasConcluidas());
    }

    @Operation(summary = "Busca todos os produtos cadastrados")
    @GetMapping(path = "/paginados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ReservaHistoricoResponseDTO>> buscarTodos(@RequestParam(defaultValue = "0") int page,
                                                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ReservaHistorico> reservaHistoricoPage = reservaHistoricoRepository.findAllByOrderByDataSolicitacaoDesc(pageable);
        Page<ReservaHistoricoResponseDTO> reservasHistoricoResponsePage = reservaHistoricoPage.map(reservaHistoricoMapper::reservaHistoricoParaReservaResponse);
        return ResponseEntity.ok().body(reservasHistoricoResponsePage);
    }

    @Operation(summary = "Deleta uma reserva do histórico")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservaHistoricoService.excluirHistoricoReserva(id);
    }
}

