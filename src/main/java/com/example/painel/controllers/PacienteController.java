package com.example.painel.controllers;

import com.example.painel.dto.paciente.CreatePacienteDto;
import com.example.painel.dto.paciente.GetPacienteDto;
import com.example.painel.dto.paciente.UpdatePacienteDto;
import com.example.painel.entities.Consulta;
import com.example.painel.entities.Paciente;
import com.example.painel.services.ConsultaService;
import com.example.painel.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

  @Autowired
  private PacienteService pacienteService;

  @Autowired
  private ConsultaService consultaService;

  @PostMapping
  public ResponseEntity<Paciente> createPaciente(@RequestBody CreatePacienteDto createPacienteDto) {
    Paciente paciente = pacienteService.createPaciente(createPacienteDto);
    return new ResponseEntity<>(paciente, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<GetPacienteDto>> getPacientes() {
    List<GetPacienteDto> pacientes = pacienteService.getPacientes();
    return new ResponseEntity<>(pacientes, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetPacienteDto> getPacienteById(@PathVariable Long id) {
    GetPacienteDto paciente = pacienteService.getPacienteById(id);
    return ResponseEntity.ok(paciente);
  }

  @GetMapping("/{id}/consultas")
  public ResponseEntity<List<Consulta>> getConsultasByPacienteId(@PathVariable Long id) {
    List<Consulta> consultas = consultaService.getConsultasByPacienteId(id);
    return new ResponseEntity<>(consultas, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody UpdatePacienteDto updatePacienteDto) {
    Paciente paciente = pacienteService.updatePaciente(id, updatePacienteDto);
    return ResponseEntity.ok(paciente);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
    pacienteService.deletePaciente(id);
    return ResponseEntity.noContent().build();
  }
}
