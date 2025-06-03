package com.example.painel.entities;

import com.example.painel.classes.User;
import com.example.painel.enums.Turno;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Aluno extends User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String matricula; 
  @ManyToOne
  @JoinColumn(name = "curso_id")
  private Curso curso;
  @Enumerated(EnumType.STRING)
  private Turno turno;

  public Aluno() { }

  public Aluno(String nome, String email, String cpf, String telefone, String senha, String matricula, Curso curso, Turno turno) {
    super(nome, email, cpf, telefone, senha);
    
    this.matricula = matricula;
    this.curso = curso;
    this.turno = turno;
  }
  
}
