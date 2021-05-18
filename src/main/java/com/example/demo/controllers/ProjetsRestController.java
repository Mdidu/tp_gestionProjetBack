package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/read")
	public List<Projet> read() {
		List<Projet> listProjets = new ArrayList<Projet>();
		listProjets = projetsService.findAll();
		return listProjets;
	}
	
	@RequestMapping("/read/{id}")
	public Projet readById(@PathVariable long id) {
		Projet projet = new Projet();
		projet = projetsService.findById(id);
		return projet;
	}

	@RequestMapping("/add")
	public void add(@RequestBody Projet projets) {
		projetsService.add(projets);
	}

	@RequestMapping("/update")
	public void update(@RequestBody Projet projets) {
		projetsService.update(projets);
	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Projet projets = projetsService.findById(id);
		projetsService.delete(projets);
	}
}