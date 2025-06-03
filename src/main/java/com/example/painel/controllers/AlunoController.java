package com.example.painel.controllers;

import com.example.painel.dto.aluno.CreateAlunoDto;
import com.example.painel.dto.aluno.UpdateAlunoDto;
import com.example.painel.entities.Aluno;
import com.example.painel.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoService alunoService;

  @PostMapping
  public ResponseEntity<Aluno> createAluno(@RequestBody CreateAlunoDto createAlunoDto) {
    Aluno aluno = alunoService.createAluno(createAlunoDto);
    return new ResponseEntity<>(aluno, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Aluno>> getAlunos() {
    List<Aluno> alunos = alunoService.getAlunos();
    return new ResponseEntity<>(alunos, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
    Aluno aluno = alunoService.getAlunoById(id);
    return ResponseEntity.ok(aluno);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody UpdateAlunoDto updateAlunoDto) {
    Aluno aluno = alunoService.updateAluno(id, updateAlunoDto);
    return ResponseEntity.ok(aluno);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
    alunoService.deleteAluno(id);
    return ResponseEntity.noContent().build();
  }
}