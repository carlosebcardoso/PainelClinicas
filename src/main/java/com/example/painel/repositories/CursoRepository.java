package com.example.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.painel.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
  
}