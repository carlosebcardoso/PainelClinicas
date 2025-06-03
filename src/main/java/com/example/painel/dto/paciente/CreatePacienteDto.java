package com.example.painel.dto.paciente;

public record CreatePacienteDto(
    String nome,
    String email,
    String cpf,
    String telefone
) {}