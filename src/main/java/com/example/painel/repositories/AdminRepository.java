package com.example.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.painel.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
  
}
