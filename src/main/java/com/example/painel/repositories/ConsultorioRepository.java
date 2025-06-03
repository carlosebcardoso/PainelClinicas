package com.example.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.painel.entities.Consultorio;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
  
}