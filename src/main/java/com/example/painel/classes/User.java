package com.example.painel.classes;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class User {

  private String nome;
  private String email;
  private String cpf;
  private String telefone;
  private String senha;

  public User() { }

  public User (String nome, String email, String cpf, String telefone, String senha) {
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    this.telefone = telefone;
    this.senha = senha;
  }
}
