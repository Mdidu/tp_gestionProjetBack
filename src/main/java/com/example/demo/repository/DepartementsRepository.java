package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Departement;

public interface DepartementsRepository extends JpaRepository<Departement, Long> {

	Optional<Departement> findByIddepartement(long id);
}
