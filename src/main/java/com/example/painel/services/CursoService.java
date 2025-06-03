package com.example.painel.services;

import com.example.painel.dto.curso.CreateCursoDto;
import com.example.painel.dto.curso.UpdateCursoDto;
import com.example.painel.entities.Curso;
import com.example.painel.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

  @Autowired
  private CursoRepository cursoRepository;

  public Curso createCurso(CreateCursoDto createCursoDto) {
    Curso curso = new Curso();
    curso.setNome(createCursoDto.nome());
    return cursoRepository.save(curso);
  }

  public List<Curso> getCursos() {
    return cursoRepository.findAll();
  }

  public Curso getCursoById(Long id) {
    return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não foi encontrado com o id: " + id));
  }

  public Curso updateCurso(Long id, UpdateCursoDto updateCursoDto) {
    Curso curso = getCursoById(id);
    if (updateCursoDto.nome() != null) {
      curso.setNome(updateCursoDto.nome());
    }
    return cursoRepository.save(curso);
  }

  public void deleteCurso(Long id) {
    Curso curso = getCursoById(id);
    cursoRepository.delete(curso);
  }
}
