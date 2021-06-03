package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Employe;
import com.example.demo.domain.Projet;


public interface EmployeRepository extends JpaRepository<Employe, Long> {

	Optional<Employe> findByMail(String mail);

	Boolean existsByMail(String email);
	
	List<Employe> findByProjet(Projet id);
}
