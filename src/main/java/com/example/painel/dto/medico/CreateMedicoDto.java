package com.example.painel.dto.medico;

public record CreateMedicoDto(
  String nome,
  String email,
  String cpf,
  String telefone,
  String crm,
  String especialidade
) { }
