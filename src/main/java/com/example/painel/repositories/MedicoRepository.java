package com.example.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.painel.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
  
}
