package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Role;
import com.example.demo.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleRestController {
	
	@Autowired
	RoleService roleService;

	@RequestMapping("/read")
	public void read() {
		List<Role> listRoles = new ArrayList<Role>();
		listRoles = roleService.findAll();
	}
	
	@RequestMapping("/read/{id}")
	public void readById(@PathVariable long id) {
		Role role = new Role();
		role = roleService.findById(id);
	}

	@RequestMapping("/add")
	public void add(@RequestBody Role role) {
		roleService.add(role);
	}

	@RequestMapping("/update")
	public void update(@RequestBody Role role) {
		roleService.update(role);
	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Role role = roleService.findById(id);
		roleService.delete(role);
	}
}
