package com.example.painel.entities;

import com.example.painel.classes.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity@Getter@Setter
public class Admin extends User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Admin() { }

  public Admin(String nome, String email, String cpf, String telefone, String senha) {
    super(nome, email, cpf, telefone, senha);
  }
  
}
