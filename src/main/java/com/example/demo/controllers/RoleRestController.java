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

import com.example.demo.domain.Role;
import com.example.demo.services.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleRestController {
	
	@Autowired
	RoleService roleService;

	@GetMapping("/read")
	public List<Role> read() {
		return roleService.findAll();
	}
	
	@GetMapping("/read/{id}")
	public Role readById(@PathVariable long id) {
		return roleService.findById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody Role role) {
		roleService.add(role);
	}

	@PutMapping("/update")
	public void update(@RequestBody Role role) {
		roleService.update(role);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Role role = roleService.findById(id);
		roleService.delete(role);
	}
}
