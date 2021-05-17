package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long> {

}
