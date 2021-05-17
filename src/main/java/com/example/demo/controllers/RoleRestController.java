package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Role;
import com.example.demo.services.RoleService;
import com.example.demo.services.RoleServiceImpl;

@RestController
//@RequestMapping("/")
public class RoleRestController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/")
	public void test() {
		Role role = new Role();
		role.setIdrole(1);
		role.setLibelle("admin");
		roleService.update(role);
		// role add & update OK
		// tester read/delete
		//tester other controller
	}
	
//	@RequestMapping("/read")
	public void read() {
		List<Role> listRoles = new ArrayList<Role>();
		listRoles = roleService.findAll();
	}
	
//	@RequestMapping("/read/")
	public void readById(long id) {
		Role role = new Role();
		role = roleService.findById(id);
	}

//	@RequestMapping("/add")
	public void add(Role role) {
		roleService.add(role);
	}

//	@RequestMapping("/update")
	public void update(Role role) {
		roleService.update(role);
	}

//	@RequestMapping("/delete")
	public void delete(long id) {
		Role role = roleService.findById(id);
		roleService.delete(role);
	}
}
