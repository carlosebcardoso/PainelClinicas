package com.example.painel.dto.medico;

public record UpdateMedicoDto(
  String nome,
  String email,
  String cpf,
  String telefone,
  String senha,
  String crm,
  String especialidade
) { }
