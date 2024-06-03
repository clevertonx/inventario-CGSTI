package com.cgsti.cgsti.repository;

import com.cgsti.cgsti.models.Equipamento;
import com.cgsti.cgsti.models.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByNomeContainingIgnoreCase(String nome);

    List<Equipamento> findByStatus(String status);

    List<Equipamento> findByTipo(String tipo);

    Page<Equipamento> findAll(Pageable pageable);
    List<Equipamento> findByReserva(Reserva reserva);


}
