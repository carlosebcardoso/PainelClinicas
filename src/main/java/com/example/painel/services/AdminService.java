package com.example.painel.services;

import com.example.painel.dto.admin.CreateAdminDto;
import com.example.painel.dto.admin.UpdateAdminDto;
import com.example.painel.entities.Admin;
import com.example.painel.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin createAdmin(CreateAdminDto createAdminDto) {
        Admin admin = new Admin(
            createAdminDto.nome(),
            createAdminDto.email(),
            createAdminDto.cpf(),
            createAdminDto.telefone(),
            "12345678"
        );
        return adminRepository.save(admin);
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Admin não foi encontrado com o id: " + id));
    }

    public Admin updateAdmin(Long id, UpdateAdminDto updateAdminDto) {
        Admin admin = getAdminById(id);

        if (updateAdminDto.nome() != null) {
            admin.setNome(updateAdminDto.nome());
        }
        if (updateAdminDto.email() != null) {
            admin.setEmail(updateAdminDto.email());
        }
        if (updateAdminDto.cpf() != null) {
            admin.setCpf(updateAdminDto.cpf());
        }
        if (updateAdminDto.telefone() != null) {
            admin.setTelefone(updateAdminDto.telefone());
        }
        if (updateAdminDto.senha() != null) {
            admin.setSenha(updateAdminDto.senha());
        }

        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        Admin admin = getAdminById(id);
        adminRepository.delete(admin);
    }
}