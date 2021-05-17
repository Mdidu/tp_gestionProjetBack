package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Projet;
import com.example.demo.services.ProjetService;

public class ProjetsRestController {
	
	@Autowired
	ProjetService projetsService;
	
	@RequestMapping("/read")
	public void read(/*long id*/) {
		List<Projet> listProjets = new ArrayList<Projet>();
		listProjets = projetsService.findAll();
	}
	
	@RequestMapping("/read/")
	public void readById(long id) {
		Projet projet = new Projet();
		projet = projetsService.findById(id);
	}

	@RequestMapping("/add")
	public void add(Projet projets) {
		projetsService.add(projets);
	}

	@RequestMapping("/update")
	public void update(Projet projets) {
		projetsService.update(projets);
	}

	@RequestMapping("/delete")
	public void delete(long id) {
		Projet projets = projetsService.findById(id);
		projetsService.delete(projets);
	}
}