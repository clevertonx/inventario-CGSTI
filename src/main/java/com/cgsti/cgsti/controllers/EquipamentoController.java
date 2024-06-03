package com.cgsti.cgsti.controllers;

import com.cgsti.cgsti.dto.EquipamentoPutDTO;
import com.cgsti.cgsti.dto.EquipamentoRequestDTO;
import com.cgsti.cgsti.dto.EquipamentoResponseDTO;
import com.cgsti.cgsti.services.EquipamentoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @Operation(summary = "Busca todos os equipamentos cadastrados")
    @GetMapping
    public ResponseEntity<List<EquipamentoResponseDTO>> findAll() {
        return ResponseEntity.ok(equipamentoService.buscarTodos());
    }

    @Operation(summary = "Busca equipamento por Id")
    @GetMapping("/{id}")
    public EquipamentoResponseDTO findById(@PathVariable Long id) {
        return equipamentoService.buscarEquipamentoPorId(id);
    }

    @Operation(summary = "Busca equipamentos disponíveis")
    @GetMapping("/disponiveis")
    public List<EquipamentoResponseDTO> findAvailableEquipments() {
        return equipamentoService.buscarEquipamentosDisponiveis();
    }

    @Operation(summary = "Cadastra um novo equipamento")
    @PostMapping
    public EquipamentoResponseDTO save(@RequestBody EquipamentoRequestDTO equipamentoRequestDTO) {
        return equipamentoService.cadastrarEquipamento(equipamentoRequestDTO);
    }

    @Operation(summary = "Altera um equipamento")
    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<EquipamentoResponseDTO> atualizarEquipamento(@RequestBody EquipamentoPutDTO equipamentoPutDTO,
                                                               @PathVariable Long id) {

        return ResponseEntity.ok(equipamentoService.atualizarEquipamento(equipamentoPutDTO, id));
    }

    @Operation(summary = "Deleta um equipamento")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        equipamentoService.excluirEquipamento(id);
    }
}
