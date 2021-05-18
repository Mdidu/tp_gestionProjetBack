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

import com.example.demo.domain.Employe;
import com.example.demo.services.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeRestController {

	@Autowired
	EmployeService employeService;
	
	@GetMapping("/read")
	public List<Employe> read() {
		List<Employe> listEmployes = new ArrayList<Employe>();
		listEmployes = employeService.findAll();
		return listEmployes;
	}
	
	@GetMapping("/read/{id}")
	public Employe readById(@PathVariable long id) {
		Employe employe = new Employe();
		employe = employeService.findById(id);
		return employe;
	}

	@PostMapping("/add")
	public void add(@RequestBody Employe employe) {
		employeService.add(employe);
	}

	@PutMapping("/update")
	public void update(@RequestBody Employe employe) {
		employeService.update(employe);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Employe employe = employeService.findById(id);
		employeService.delete(employe);
	}
}
