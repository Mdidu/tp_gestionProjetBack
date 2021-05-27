package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/projet")
public class ProjetsRestController {
	
	@Autowired
	ProjetService projetsService;
	
	@GetMapping("/read")
	public List<Projet> read() {
		return projetsService.findAll();
	}
	
	@GetMapping("/read/{id}")
	public Projet readById(@PathVariable long id) {
		return projetsService.findById(id);
	}
	
	@GetMapping("/read/date/dateDebut/{dateDebut}/dateFin/{dateFin}")
	public List<Projet> readByDate(@PathVariable String dateDebut, @PathVariable String dateFin) throws ParseException {

		Date dDebut = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut);
		Date dFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);

		return projetsService.findByDatedebutAndDatefinestimee(dDebut, dFin);
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