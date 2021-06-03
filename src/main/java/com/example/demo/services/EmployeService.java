package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Employe;
import com.example.demo.domain.Projet;

public interface EmployeService extends GlobalService<Employe> {

	List<Employe> findByProjet(Projet id);
	Optional<Employe> findByMail(String mail);
	boolean existsByMail(String email);
}
