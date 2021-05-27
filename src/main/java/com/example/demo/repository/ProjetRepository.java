package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
	@Query(value = "select p from Projet p where (datedebut BETWEEN ?1 and ?2) or (datefinestimee BETWEEN ?1 and ?2)")
	List<Projet> findByDatedebutAndDatefinestimee(Date dateDebut, Date dateFin);
}
