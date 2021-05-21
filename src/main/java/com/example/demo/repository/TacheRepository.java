package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Module;
import com.example.demo.domain.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long> {
	
	List<Tache> findByModule(Module module);
}
