package com.cgsti.cgsti.Mappers;

import com.cgsti.cgsti.dto.EquipamentoRequestDTO;
import com.cgsti.cgsti.dto.EquipamentoResponseDTO;
import com.cgsti.cgsti.models.Equipamento;
import com.cgsti.cgsti.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EquipamentoMapperImpl implements EquipamentoMapper{



    @Override
    public Equipamento equipamentoRequestParaEquipamento(EquipamentoRequestDTO equipamentoRequestDTO) {
        return new Equipamento(
                null,
                equipamentoRequestDTO.getNome(),
                equipamentoRequestDTO.getTipo(),
                equipamentoRequestDTO.getNumeroSerie(),
                equipamentoRequestDTO.getMarca(),
                equipamentoRequestDTO.getModelo(),
                equipamentoRequestDTO.getHdSsd(),
                equipamentoRequestDTO.getProcessador(),
                equipamentoRequestDTO.getPlacaDeVideo(),
                equipamentoRequestDTO.getMemoriaRam(),
                equipamentoRequestDTO.getSistemaOperacional(),
                equipamentoRequestDTO.getArquitetura(),
                equipamentoRequestDTO.getEnderecoMac(),
                equipamentoRequestDTO.getEtiqueta(),
                null,
                null
        );
    }

    @Override
    public EquipamentoResponseDTO equipamentoParaEquipamentoResponse(Equipamento equipamento) {
        return new EquipamentoResponseDTO(equipamento.getId(), equipamento.getNome(),
                equipamento.getTipo(), equipamento.getStatus(),
                equipamento.getNumeroSerie(), equipamento.getMarca(),
                equipamento.getModelo(), equipamento.getHdSsd(),
                equipamento.getProcessador(), equipamento.getPlacaDeVideo(),
                equipamento.getMemoriaRam(), equipamento.getSistemaOperacional(),
                equipamento.getArquitetura(), equipamento.getEnderecoMac(), equipamento.getEtiqueta());
    }

    @Override
    public List<EquipamentoResponseDTO> equipamentosParaEquipamentoResponses(List<Equipamento> equipamentos) {
        List<EquipamentoResponseDTO> equipamentoResponseDTOS = new ArrayList<>();
        for (Equipamento equipamento : equipamentos) {
            equipamentoResponseDTOS.add(equipamentoParaEquipamentoResponse(equipamento));
        }
        return equipamentoResponseDTOS;
    }
}
