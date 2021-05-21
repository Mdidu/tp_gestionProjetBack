package com.example.demo.repository;

import com.example.demo.domain.Module;
import com.example.demo.domain.Projet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
	List<Module> findByProjet(Projet id);
}
