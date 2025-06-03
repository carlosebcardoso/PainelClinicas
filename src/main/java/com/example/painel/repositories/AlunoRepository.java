package com.example.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.painel.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
  
}