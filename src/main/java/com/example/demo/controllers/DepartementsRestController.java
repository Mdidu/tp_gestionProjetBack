package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Departement;
import com.example.demo.services.DepartementsService;

@RestController
@RequestMapping("/departement")
public class DepartementsRestController {

	@Autowired
	DepartementsService departementsService;
	
	@RequestMapping("/read")
	public void read() {
		List<Departement> listDepartements = new ArrayList<Departement>();
		listDepartements = departementsService.findAll();
	}
	
	@RequestMapping("/read/{id}")
	public void readById(@PathVariable long id) {
		Departement departement = new Departement();
		departement = departementsService.findById(id);
	}

	@RequestMapping("/add")
	public void add(Departement departement) {
		departementsService.add(departement);
	}

	@RequestMapping("/update")
	public void update(Departement departement) {
		departementsService.update(departement);
	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Departement departement = departementsService.findById(id);
		departementsService.delete(departement);
	}
}