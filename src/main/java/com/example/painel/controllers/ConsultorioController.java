package com.example.painel.controllers;

import com.example.painel.dto.consultorio.CreateConsultorioDto;
import com.example.painel.dto.consultorio.UpdateConsultorioDto;
import com.example.painel.entities.Consultorio;
import com.example.painel.services.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {

    @Autowired
    private ConsultorioService consultorioService;

    @PostMapping
    public ResponseEntity<Consultorio> createConsultorio(@RequestBody CreateConsultorioDto createConsultorioDto) {
        Consultorio consultorio = consultorioService.createConsultorio(createConsultorioDto);
        return new ResponseEntity<>(consultorio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Consultorio>> getConsultorios() {
        List<Consultorio> consultorios = consultorioService.getConsultorios();
        return new ResponseEntity<>(consultorios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultorio> getConsultorioById(@PathVariable Long id) {
        Consultorio consultorio = consultorioService.getConsultorioById(id);
        return ResponseEntity.ok(consultorio);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Consultorio> updateConsultorio(@PathVariable Long id, @RequestBody UpdateConsultorioDto updateConsultorioDto) {
        Consultorio consultorio = consultorioService.updateConsultorio(id, updateConsultorioDto);
        return ResponseEntity.ok(consultorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultorio(@PathVariable Long id) {
        consultorioService.deleteConsultorio(id);
        return ResponseEntity.noContent().build();
    }
}
