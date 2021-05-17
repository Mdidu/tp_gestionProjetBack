package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Departement;
import com.example.demo.services.DepartementsService;

public class DepartementsRestController {

	@Autowired
	DepartementsService departementsService;
	
	@RequestMapping("/read")
	public void read(/*long id*/) {
		List<Departement> listDepartements = new ArrayList<Departement>();
		listDepartements = departementsService.findAll();
	}
	
	@RequestMapping("/read/")
	public void readById(long id) {
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

	@RequestMapping("/delete")
	public void delete(long id) {
		Departement departement = departementsService.findById(id);
		departementsService.delete(departement);
	}
}