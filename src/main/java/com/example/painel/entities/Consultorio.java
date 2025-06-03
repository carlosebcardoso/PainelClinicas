package com.example.painel.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity@Getter@Setter
public class Consultorio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numeroSala;

  public Consultorio() { }

  public Consultorio(String numeroSala) {
    this.numeroSala = numeroSala;
  }
}
