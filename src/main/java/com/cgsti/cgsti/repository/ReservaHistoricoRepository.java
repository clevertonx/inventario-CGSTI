package com.cgsti.cgsti.repository;

import com.cgsti.cgsti.models.Equipamento;
import com.cgsti.cgsti.models.ReservaHistorico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaHistoricoRepository extends JpaRepository<ReservaHistorico, Long> {

    Page<ReservaHistorico> findAll(Pageable pageable);
}
