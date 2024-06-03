package com.cgsti.cgsti.services;

import com.cgsti.cgsti.Mappers.EquipamentoMapper;
import com.cgsti.cgsti.dto.EquipamentoPutDTO;
import com.cgsti.cgsti.dto.EquipamentoRequestDTO;
import com.cgsti.cgsti.dto.EquipamentoResponseDTO;
import com.cgsti.cgsti.models.Equipamento;
import com.cgsti.cgsti.models.StatusEquipamento;
import com.cgsti.cgsti.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    private final EquipamentoMapper equipamentoMapper;

    public List<EquipamentoResponseDTO> buscarTodos() {
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        return equipamentoMapper.equipamentosParaEquipamentoResponses(equipamentos);
    }


    public EquipamentoResponseDTO buscarEquipamentoPorId(Long id) {
        return equipamentoRepository.findById(id)
                .map(equipamentoMapper::equipamentoParaEquipamentoResponse)
                .orElse(null);
    }

    public List<EquipamentoResponseDTO> buscarEquipamentosDisponiveis() {
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        List<Equipamento> equipamentosDisponiveis = new ArrayList<>();

        for (Equipamento equipamento : equipamentos) {
            // Verifica se o equipamento está vinculado a alguma reserva
            boolean emprestado = equipamento.getReserva() != null;

            // Atualiza o status do equipamento com base na condição
            if (emprestado) {
                equipamento.setStatus(StatusEquipamento.EMPRESTADO);
            } else {
                equipamento.setStatus(StatusEquipamento.DISPONIVEL);
            }

            // Atualiza o equipamento no banco de dados
            equipamentoRepository.save(equipamento);

            // Adiciona o equipamento atualizado à lista de equipamentos disponíveis
            equipamentosDisponiveis.add(equipamento);
        }

        return equipamentoMapper.equipamentosParaEquipamentoResponses(equipamentosDisponiveis);
    }


    public EquipamentoResponseDTO cadastrarEquipamento(EquipamentoRequestDTO equipamentoRequestDTO) {
        Equipamento equipamento = equipamentoMapper.equipamentoRequestParaEquipamento(equipamentoRequestDTO);
        equipamento.setStatus(StatusEquipamento.DISPONIVEL);  // Define o status como DISPONIVEL
        Equipamento savedEquipamento = equipamentoRepository.save(equipamento);
        return equipamentoMapper.equipamentoParaEquipamentoResponse(savedEquipamento);
    }




    public EquipamentoResponseDTO atualizarEquipamento(EquipamentoPutDTO equipamentoPutDTO, long id) {

        Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(id);
        if (equipamentoOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        Equipamento equipamento = equipamentoOptional.get();
        equipamento.setNome(equipamentoPutDTO.getNome());
        equipamento.setTipo(equipamentoPutDTO.getTipo());
        equipamentoRepository.save(equipamento);

        return equipamentoMapper.equipamentoParaEquipamentoResponse(equipamento);
    }

    public void excluirEquipamento(Long id) {
        equipamentoRepository.deleteById(id);
    }


}