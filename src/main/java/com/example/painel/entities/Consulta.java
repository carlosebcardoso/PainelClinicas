package com.example.painel.entities;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity@Getter@Setter
public class Consulta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  @ManyToOne
  @JoinColumn(name = "medico_id")
  private Medico medico;

  @ManyToOne
  @JoinColumn(name = "paciente_id")
  private Paciente paciente;

  @ManyToOne
  @JoinColumn(name = "consultorio_id")
  private Consultorio consultorio;
  
  private LocalDateTime dataHora;
  private String tipo;
  private String status;

  public Consulta() { }

  public Consulta(Aluno aluno, Medico medico, Paciente paciente, Consultorio consultorio, LocalDateTime dataHora, String tipo, String status) {
    this.aluno = aluno;
    this.medico = medico;
    this.paciente = paciente;
    this.consultorio = consultorio;
    this.dataHora = dataHora;
    this.tipo = tipo;
    this.status = status;
  }

}
