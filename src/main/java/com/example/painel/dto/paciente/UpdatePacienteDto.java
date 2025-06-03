package com.example.painel.dto.paciente;

public record UpdatePacienteDto(
    String nome,
    String email,
    String cpf,
    String telefone,
    String senha
) {}