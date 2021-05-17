package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Departement;

public interface DepartementsRepository extends JpaRepository<Departement, Long> {

}
