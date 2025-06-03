package com.example.painel.dto.consulta;

public record UpdateConsultaDto(
  Long alunoId,
  Long medicoId,
  Long consultorioId,
  String dataHora,
  String tipo,
  String status
) { }
