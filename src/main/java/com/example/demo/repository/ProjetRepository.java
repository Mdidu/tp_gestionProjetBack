package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
