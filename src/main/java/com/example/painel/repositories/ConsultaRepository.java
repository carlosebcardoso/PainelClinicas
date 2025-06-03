package com.example.painel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.painel.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
  List<Consulta> findByPacienteId(Long pacienteId);
}