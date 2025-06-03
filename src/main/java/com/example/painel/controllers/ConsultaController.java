package com.example.painel.controllers;

import com.example.painel.dto.consulta.CreateConsultaDto;
import com.example.painel.dto.consulta.UpdateConsultaDto;
import com.example.painel.entities.Consulta;
import com.example.painel.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> createConsulta(@RequestBody CreateConsultaDto createConsultaDto) {
        Consulta consulta = consultaService.createConsulta(createConsultaDto);
        return new ResponseEntity<>(consulta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> getConsultas() {
        List<Consulta> consultas = consultaService.getConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        Consulta consulta = consultaService.getConsultaById(id);
        return ResponseEntity.ok(consulta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody UpdateConsultaDto updateConsultaDto) {
        Consulta consulta = consultaService.updateConsulta(id, updateConsultaDto);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }
}