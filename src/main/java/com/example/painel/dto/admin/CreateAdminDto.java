package com.example.painel.dto.admin;

public record CreateAdminDto(
  String nome,
  String email,
  String cpf,
  String telefone
) { }
