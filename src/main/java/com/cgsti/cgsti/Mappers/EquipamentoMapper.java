package com.cgsti.cgsti.Mappers;

import com.cgsti.cgsti.dto.EquipamentoRequestDTO;
import com.cgsti.cgsti.dto.EquipamentoResponseDTO;
import com.cgsti.cgsti.models.Equipamento;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipamentoMapper {

    Equipamento equipamentoRequestParaEquipamento(EquipamentoRequestDTO EquipamentoRequestDTO);

    EquipamentoResponseDTO equipamentoParaEquipamentoResponse(Equipamento equipamento);

    List<EquipamentoResponseDTO> equipamentosParaEquipamentoResponses(List<Equipamento> equipamentos);


}
