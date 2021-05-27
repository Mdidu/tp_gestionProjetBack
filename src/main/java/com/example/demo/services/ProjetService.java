package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.domain.Projet;

public interface ProjetService extends GlobalService<Projet> {
	
	List<Projet> findByDatedebutAndDatefinestimee(Date dateDebut, Date dateFin);
}
