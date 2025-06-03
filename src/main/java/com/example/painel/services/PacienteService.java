package com.example.painel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.painel.dto.paciente.*;
import com.example.painel.entities.Paciente;
import com.example.painel.repositories.PacienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
  @Autowired
  private PacienteRepository pacienteRepository;
  public Paciente createPaciente(CreatePacienteDto createPacienteDto) {
    Paciente paciente = new Paciente(
      createPacienteDto.nome(),
      createPacienteDto.email(),
      createPacienteDto.cpf(),
      createPacienteDto.telefone(),
      "12345678");
    return pacienteRepository.save(paciente);
  }

  private GetPacienteDto convertToDTO(Paciente paciente) {
    GetPacienteDto dto = new GetPacienteDto(
      paciente.getId(),
      paciente.getNome(),
      paciente.getEmail(),
      paciente.getCpf(),
      paciente.getTelefone()
    );
    return dto;
  }

  public List<GetPacienteDto> getPacientes() {
    return pacienteRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
  }

  public GetPacienteDto getPacienteById(Long id) {
    return pacienteRepository.findById(id)
      .map(this::convertToDTO)
      .orElseThrow(() -> new RuntimeException("Paciente não foi encontrado com o id: " + id));
  }

  public Paciente findPacienteById(Long id) {
    return pacienteRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Paciente não foi encontrado com o id: " + id));
  }
  
  public Paciente updatePaciente(Long id, UpdatePacienteDto updatePacienteDto) {
    Paciente paciente = findPacienteById(id);

    if (updatePacienteDto.nome() != null) {
        paciente.setNome(updatePacienteDto.nome());
    }
    if (updatePacienteDto.email() != null) {
        paciente.setEmail(updatePacienteDto.email());
    }
    if (updatePacienteDto.cpf() != null) {
        paciente.setCpf(updatePacienteDto.cpf());
    }
    if (updatePacienteDto.telefone() != null) {
        paciente.setTelefone(updatePacienteDto.telefone());
    }
    if (updatePacienteDto.senha() != null) {
        paciente.setSenha(updatePacienteDto.senha());
    }

    return pacienteRepository.save(paciente);
  }

  public void deletePaciente(Long id) {
    Paciente paciente = findPacienteById(id);
    pacienteRepository.delete(paciente);
  }
}
