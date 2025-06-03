package com.example.painel.entities;

import com.example.painel.enums.Turno;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  @ElementCollection
  @CollectionTable(name = "curso_turnos", joinColumns = @JoinColumn(name = "curso_id"))
  @Enumerated(EnumType.STRING)
  private List<Turno> turnos;

  public Curso() { }

  public Curso(String nome) {
    this.nome = nome;
  }

  public void addTurno(Turno turno) {
    if (this.turnos == null) {
      this.turnos = new ArrayList<>();
    }
    this.turnos.add(turno);
  }

}
