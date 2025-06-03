package com.example.painel.services;

import com.example.painel.dto.consulta.CreateConsultaDto;
import com.example.painel.dto.consulta.UpdateConsultaDto;
import com.example.painel.entities.Consulta;
import com.example.painel.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ConsultorioService consultorioService;

    public Consulta createConsulta(CreateConsultaDto createConsultaDto) {
        Consulta consulta = new Consulta(
            alunoService.getAlunoById(createConsultaDto.alunoId()),
            medicoService.getMedicoById(createConsultaDto.medicoId()),
            pacienteService.findPacienteById(createConsultaDto.pacienteId()),
            consultorioService.getConsultorioById(createConsultaDto.consultorioId()),
            LocalDateTime.parse(
                createConsultaDto.dataHora(),
                DateTimeFormatter.ISO_DATE_TIME
            ),
            createConsultaDto.tipo(),
            createConsultaDto.status()
        );
        return consultaRepository.save(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(Long id) {
        return consultaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Consulta não foi encontrada com o id: " + id));
    }

    public List<Consulta> getConsultasByPacienteId(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId);
    }

    public Consulta updateConsulta(Long id, UpdateConsultaDto updateConsultaDto) {
        Consulta consulta = getConsultaById(id);

        if (updateConsultaDto.dataHora() != null) {
            LocalDateTime.parse(
                updateConsultaDto.dataHora(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );
        }
        if (updateConsultaDto.alunoId() != null) {
            consulta.setAluno(alunoService.getAlunoById(updateConsultaDto.alunoId()));
        }
        if (updateConsultaDto.medicoId() != null) {
            consulta.setMedico(medicoService.getMedicoById(updateConsultaDto.medicoId()));
        }
        if (updateConsultaDto.consultorioId() != null) {
            consulta.setConsultorio(consultorioService.getConsultorioById(updateConsultaDto.consultorioId()));
        }
        if (updateConsultaDto.tipo() != null) {
            consulta.setTipo(updateConsultaDto.tipo());
        }

        if (updateConsultaDto.status() != null) {
            consulta.setStatus(updateConsultaDto.status());
        }

        return consultaRepository.save(consulta);
    }

    public void deleteConsulta(Long id) {
        Consulta consulta = getConsultaById(id);
        consultaRepository.delete(consulta);
    }
}