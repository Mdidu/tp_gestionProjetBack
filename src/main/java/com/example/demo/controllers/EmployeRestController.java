package com.example.demo.controllers;

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

import com.example.demo.domain.Employe;
import com.example.demo.domain.Projet;
import com.example.demo.services.EmployeService;
import com.example.demo.util.Encrypt;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employe")
public class EmployeRestController {

	@Autowired
	EmployeService employeService;
	
	@GetMapping("/read")
	public List<Employe> read() {
		
		return employeService.findAll();
	}
	
	@GetMapping("/read/{id}")
	public Employe readById(@PathVariable long id) {
		return employeService.findById(id);
	}
	
	@GetMapping("/projet/{id}")
	public List<Employe> readByProjetId(@PathVariable long id) {
		return employeService.findByProjet(new Projet(id));
		
	}

	@PostMapping("/add")
	public void add(@RequestBody Employe employe) {
		employe.setPwd(Encrypt.encoder().encode(employe.getPwd()));
		employeService.add(employe);
	}

	@PutMapping("/update")
	public void update(@RequestBody Employe employe) {
		System.out.println("aaa");
		System.out.println(employe.toString());
		employeService.update(employe);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Employe employe = employeService.findById(id);
		employeService.delete(employe);
	}
}
