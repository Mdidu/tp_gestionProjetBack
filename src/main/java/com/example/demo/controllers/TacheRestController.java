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

import com.example.demo.domain.Tache;
import com.example.demo.services.TacheService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tache")
public class TacheRestController {
	
	@Autowired
	TacheService tacheService;
	
	@GetMapping("/read")
	public List<Tache> read() {
		return tacheService.findAll();
	}
	
	@GetMapping("/read/{id}")
	public Tache readById(@PathVariable long id) {
		return tacheService.findById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody Tache tache) {
		tacheService.add(tache);
	}

	@PutMapping("/update")
	public void update(@RequestBody Tache tache) {
		tacheService.update(tache);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Tache tache = tacheService.findById(id);
		tacheService.delete(tache);
	}
}
