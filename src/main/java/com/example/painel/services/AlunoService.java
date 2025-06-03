package com.example.painel.services;

import com.example.painel.dto.aluno.UpdateAlunoDto;
import com.example.painel.dto.aluno.CreateAlunoDto;
import com.example.painel.entities.Aluno;
import com.example.painel.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

  @Autowired
  private AlunoRepository alunoRepository;

  @Autowired
  private CursoService cursoService;

  public Aluno createAluno(CreateAlunoDto createAlunoDto) {
    Aluno aluno;
    aluno = new Aluno(
      createAlunoDto.nome(),
      createAlunoDto.email(),
      createAlunoDto.cpf(),
      createAlunoDto.telefone(),
      "12345678",
      createAlunoDto.matricula(),
      cursoService.getCursoById(createAlunoDto.cursoId()),
      com.example.painel.enums.Turno.valueOf(createAlunoDto.turno()));
    return alunoRepository.save(aluno);
  }

  public List<Aluno> getAlunos() {
    return alunoRepository.findAll();
  }

  public Aluno getAlunoById(Long id) {
    return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não foi encontrado com o id: " + id));
  }

  public Aluno updateAluno(Long id, UpdateAlunoDto updateAlunoDto) {
    Aluno aluno = alunoRepository.findById(id).orElseThrow();

    if (updateAlunoDto.nome() != null) {
      aluno.setNome(updateAlunoDto.nome());
    }
    if (updateAlunoDto.email() != null) {
      aluno.setEmail(updateAlunoDto.email());
    }
    if (updateAlunoDto.cpf() != null) {
      aluno.setCpf(updateAlunoDto.cpf());
    }
    if (updateAlunoDto.telefone() != null) {
      aluno.setTelefone(updateAlunoDto.telefone());
    }
    if (updateAlunoDto.senha() != null) {
      aluno.setSenha(updateAlunoDto.senha());
    }
    if (updateAlunoDto.matricula() != null) {
      aluno.setMatricula(updateAlunoDto.matricula());
    }
    if (updateAlunoDto.turno() != null) {
      aluno.setTurno(com.example.painel.enums.Turno.valueOf(updateAlunoDto.turno()));
    }
    return alunoRepository.save(aluno);
  }

  public void deleteAluno(Long id) {
    alunoRepository.deleteById(id);
  }
}