package com.example.painel.services;

import com.example.painel.dto.medico.CreateMedicoDto;
import com.example.painel.dto.medico.UpdateMedicoDto;
import com.example.painel.entities.Medico;
import com.example.painel.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico createMedico(CreateMedicoDto createMedicoDto) {
        Medico medico = new Medico(
            createMedicoDto.nome(),
            createMedicoDto.email(),
            createMedicoDto.cpf(),
            createMedicoDto.telefone(),
            "12345678",
            createMedicoDto.crm(),
            createMedicoDto.especialidade()
        );
        return medicoRepository.save(medico);
    }

    public List<Medico> getMedicos() {
        return medicoRepository.findAll();
    }

    public Medico getMedicoById(Long id) {
        return medicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Medico não foi encontrado com o id: " + id));
    }

    public Medico updateMedico(Long id, UpdateMedicoDto updateMedicoDto) {
        Medico medico = getMedicoById(id);

        if (updateMedicoDto.nome() != null) {
            medico.setNome(updateMedicoDto.nome());
        }
        if (updateMedicoDto.email() != null) {
            medico.setEmail(updateMedicoDto.email());
        }
        if (updateMedicoDto.cpf() != null) {
            medico.setCpf(updateMedicoDto.cpf());
        }
        if (updateMedicoDto.telefone() != null) {
            medico.setTelefone(updateMedicoDto.telefone());
        }
        if (updateMedicoDto.senha() != null) {
            medico.setSenha(updateMedicoDto.senha());
        }
        if (updateMedicoDto.crm() != null) {
            medico.setCrm(updateMedicoDto.crm());
        }
        if (updateMedicoDto.especialidade() != null) {
            medico.setEspecialidade(updateMedicoDto.especialidade());
        }

        return medicoRepository.save(medico);
    }

    public void deleteMedico(Long id) {
        Medico medico = getMedicoById(id);
        medicoRepository.delete(medico);
    }
}