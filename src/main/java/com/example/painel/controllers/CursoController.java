package com.example.painel.controllers;

import com.example.painel.dto.curso.CreateCursoDto;
import com.example.painel.dto.curso.UpdateCursoDto;
import com.example.painel.entities.Curso;
import com.example.painel.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

  @Autowired
  private CursoService cursoService;

  @PostMapping
  public ResponseEntity<Curso> createCurso(@RequestBody CreateCursoDto createCursoDto) {
    Curso curso = cursoService.createCurso(createCursoDto);
    return new ResponseEntity<>(curso, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Curso>> getCursos() {
    List<Curso> cursos = cursoService.getCursos();
    return new ResponseEntity<>(cursos, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
    Curso curso = cursoService.getCursoById(id);
    return ResponseEntity.ok(curso);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody UpdateCursoDto updateCursoDto) {
    Curso curso = cursoService.updateCurso(id, updateCursoDto);
    return ResponseEntity.ok(curso);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
    cursoService.deleteCurso(id);
    return ResponseEntity.noContent().build();
  }
}
