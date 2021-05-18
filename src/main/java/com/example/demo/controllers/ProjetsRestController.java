package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Projet;
import com.example.demo.services.ProjetService;

@RestController
@RequestMapping("/projet")
public class ProjetsRestController {
	
	@Autowired
	ProjetService projetsService;
	
	@GetMapping("/read")
	public List<Projet> read() {
		List<Projet> listProjets = new ArrayList<Projet>();
		listProjets = projetsService.findAll();
		return listProjets;
	}
	
	@GetMapping("/read/{id}")
	public Projet readById(@PathVariable long id) {
		Projet projet = new Projet();
		projet = projetsService.findById(id);
		return projet;
	}

	@PostMapping("/add")
	public void add(@RequestBody Projet projets) {
		projetsService.add(projets);
	}

	@PutMapping("/update")
	public void update(@RequestBody Projet projets) {
		projetsService.update(projets);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Projet projets = projetsService.findById(id);
		projetsService.delete(projets);
	}
}