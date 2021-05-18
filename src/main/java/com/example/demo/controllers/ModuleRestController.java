package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Module;
import com.example.demo.services.ModuleService;

@RestController
@RequestMapping("/module")
public class ModuleRestController {
	@Autowired
	ModuleService moduleService;
	
	@RequestMapping("/read")
	public void read(/*long id*/) {
		List<Module> listModules = new ArrayList<Module>();
		listModules = moduleService.findAll();
	}
	
	@RequestMapping("/read/{id}")
	public void readById(@PathVariable long id) {
		Module module = new Module();
		module = moduleService.findById(id);
	}

	@RequestMapping("/add")
	public void add(Module module) {
		moduleService.add(module);
	}

	@RequestMapping("/update")
	public void update(Module module) {
		moduleService.update(module);
	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Module module = moduleService.findById(id);
		moduleService.delete(module);
	}
}
