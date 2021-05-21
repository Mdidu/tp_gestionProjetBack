package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Module;
import com.example.demo.domain.Projet;

public interface ModuleService extends GlobalService<Module> {
	List<Module> findByProjet(Projet id);
}
