package com.cgsti.cgsti.repository;

import com.cgsti.cgsti.models.Equipamento;
import com.cgsti.cgsti.models.Reserva;
import com.cgsti.cgsti.models.TipoEquipamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByNomeContainingIgnoreCase(String nome);

    List<Equipamento> findByStatus(String status);

    List<Equipamento> findByTipoEquipamento(TipoEquipamento tipoEquipamento);

    Page<Equipamento> findAll(Pageable pageable);
    List<Equipamento> findByReserva(Reserva reserva);


}
