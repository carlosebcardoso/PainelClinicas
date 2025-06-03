package com.example.painel.dto.admin;

public record UpdateAdminDto(
  String nome,
  String email,
  String cpf,
  String telefone,
  String senha
) { }
