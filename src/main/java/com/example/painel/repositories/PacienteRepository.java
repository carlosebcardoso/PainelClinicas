package com.example.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.painel.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
  
}