package com.example.demo.services;

import java.util.Optional;

import com.example.demo.domain.Departement;

public interface DepartementsService extends GlobalService<Departement> {
	Optional<Departement> findByIddepartement(long id);
}
