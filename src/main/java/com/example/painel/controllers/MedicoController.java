package com.example.painel.controllers;

import com.example.painel.dto.medico.CreateMedicoDto;
import com.example.painel.dto.medico.UpdateMedicoDto;
import com.example.painel.entities.Medico;
import com.example.painel.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody CreateMedicoDto createMedicoDto) {
        Medico medico = medicoService.createMedico(createMedicoDto);
        return new ResponseEntity<>(medico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getMedicos() {
        List<Medico> medicos = medicoService.getMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) {
        Medico medico = medicoService.getMedicoById(id);
        return ResponseEntity.ok(medico);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody UpdateMedicoDto updateMedicoDto) {
        Medico medico = medicoService.updateMedico(id, updateMedicoDto);
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
        return ResponseEntity.noContent().build();
    }
}