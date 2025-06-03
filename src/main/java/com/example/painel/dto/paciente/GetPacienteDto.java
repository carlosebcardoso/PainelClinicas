package com.example.painel.dto.paciente;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class GetPacienteDto {
  private Long id;
  private String nome;
  private String email;
  private String cpf;
  private String telefone;

  public GetPacienteDto (Long id, String nome, String email, String cpf, String telefone) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    this.telefone = telefone;
  }
}