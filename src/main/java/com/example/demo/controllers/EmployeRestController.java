package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employe;
import com.example.demo.services.DepartementsService;
import com.example.demo.services.EmployeService;
import com.example.demo.services.ProjetService;
import com.example.demo.services.RoleService;

@RestController
@RequestMapping("/employe")
public class EmployeRestController {

	@Autowired
	EmployeService employeService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ProjetService projetsService;
	
	@Autowired
	DepartementsService departementsService;
	
	@RequestMapping("/read")
	public void read(/*long id*/) {
		List<Employe> listEmployes = new ArrayList<Employe>();
		listEmployes = employeService.findAll();
	}
	
	@RequestMapping("/read/")
	public void readById(long id) {
		Employe employe = new Employe();
		employe = employeService.findById(id);
	}

	@RequestMapping("/add")
	public void add(Employe employe) {
		employeService.add(employe);
	}

	@RequestMapping("/update")
	public void update(Employe employe) {
		employeService.update(employe);
	}

	@RequestMapping("/delete")
	public void delete(long id) {
		Employe employe = employeService.findById(id);
		employeService.delete(employe);
	}
}
