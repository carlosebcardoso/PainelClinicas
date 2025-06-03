package com.example.painel.services;

import com.example.painel.dto.consultorio.CreateConsultorioDto;
import com.example.painel.dto.consultorio.UpdateConsultorioDto;
import com.example.painel.entities.Consultorio;
import com.example.painel.repositories.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorioService {

    @Autowired
    private ConsultorioRepository consultorioRepository;

    public Consultorio createConsultorio(CreateConsultorioDto createConsultorioDto) {
        Consultorio consultorio = new Consultorio(
            createConsultorioDto.numeroSala()
        );
        return consultorioRepository.save(consultorio);
    }

    public List<Consultorio> getConsultorios() {
        return consultorioRepository.findAll();
    }

    public Consultorio getConsultorioById(Long id) {
        return consultorioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Consultório não foi encontrado com o id: " + id));
    }

    public Consultorio updateConsultorio(Long id, UpdateConsultorioDto updateConsultorioDto) {
        Consultorio consultorio = getConsultorioById(id);

        if (updateConsultorioDto.numeroSala() != null) {
            consultorio.setNumeroSala(updateConsultorioDto.numeroSala());
        }

        return consultorioRepository.save(consultorio);
    }

    public void deleteConsultorio(Long id) {
        Consultorio consultorio = getConsultorioById(id);
        consultorioRepository.delete(consultorio);
    }
}