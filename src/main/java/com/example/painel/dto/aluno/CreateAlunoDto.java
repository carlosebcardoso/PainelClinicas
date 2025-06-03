package com.example.painel.dto.aluno;

public record CreateAlunoDto(
    String nome,
    String email,
    String cpf,
    String telefone,
    String matricula,
    Long cursoId,
    String turno
) {}