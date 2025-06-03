package com.example.painel.controllers;

import com.example.painel.dto.admin.CreateAdminDto;
import com.example.painel.dto.admin.UpdateAdminDto;
import com.example.painel.entities.Admin;
import com.example.painel.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody CreateAdminDto createAdminDto) {
        Admin admin = adminService.createAdmin(createAdminDto);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAdmins() {
        List<Admin> admins = adminService.getAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody UpdateAdminDto updateAdminDto) {
        Admin admin = adminService.updateAdmin(id, updateAdminDto);
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}