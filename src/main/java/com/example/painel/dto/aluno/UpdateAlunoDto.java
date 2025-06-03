package com.example.painel.dto.aluno;

public record UpdateAlunoDto(
    String nome,
    String email,
    String cpf,
    String telefone,
    String senha,
    String matricula,
    Long cursoId,
    String turno
) {}