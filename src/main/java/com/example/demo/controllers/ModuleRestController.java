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

import com.example.demo.domain.Module;
import com.example.demo.services.ModuleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/module")
public class ModuleRestController {
	@Autowired
	ModuleService moduleService;
	
	@GetMapping("/read")
	public List<Module> read() {
		return moduleService.findAll();
	}
	
	@GetMapping("/read/{id}")
	public Module readById(@PathVariable long id) {
		return moduleService.findById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody Module module) {
		moduleService.add(module);
	}

	@PutMapping("/update")
	public void update(@RequestBody Module module) {
		moduleService.update(module);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Module module = moduleService.findById(id);
		moduleService.delete(module);
	}
}
