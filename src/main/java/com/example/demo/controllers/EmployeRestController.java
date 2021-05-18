package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employe;
import com.example.demo.services.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeRestController {

	@Autowired
	EmployeService employeService;
	
	@RequestMapping("/read")
	public List<Employe> read() {
		List<Employe> listEmployes = new ArrayList<Employe>();
		listEmployes = employeService.findAll();
		return listEmployes;
	}
	
	@RequestMapping("/read/{id}")
	public Employe readById(@PathVariable long id) {
		Employe employe = new Employe();
		employe = employeService.findById(id);
		return employe;
	}

	@RequestMapping("/add")
	public void add(@RequestBody Employe employe) {
		employeService.add(employe);
	}

	@RequestMapping("/update")
	public void update(@RequestBody Employe employe) {
		employeService.update(employe);
	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Employe employe = employeService.findById(id);
		employeService.delete(employe);
	}
}
