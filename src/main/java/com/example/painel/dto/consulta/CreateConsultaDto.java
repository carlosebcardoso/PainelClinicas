package com.example.painel.dto.consulta;

public record CreateConsultaDto(
  Long alunoId,
  Long medicoId,
  Long pacienteId,
  Long consultorioId,
  String dataHora,
  String tipo,
  String status
) { }
