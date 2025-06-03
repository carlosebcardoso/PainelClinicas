package com.example.painel.entities;

import com.example.painel.classes.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Medico extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String crm;
  private String especialidade;

  public Medico() { }

  public Medico(String nome, String email, String cpf, String telefone, String senha, String crm, String especialidade) {
    super(nome, email, cpf, telefone, senha);

    this.crm = crm;
    this.especialidade = especialidade;
  }
  
}
