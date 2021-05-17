package com.example.demo.controllers;

import com.example.demo.domain.Module;
import com.example.demo.services.ModuleService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class ModuleRestController {
	@Autowired
	ModuleService moduleService;
	
	@RequestMapping("/read")
	public void read(/*long id*/) {
		List<Module> listModules = new ArrayList<Module>();
		listModules = moduleService.findAll();
	}
	
	@RequestMapping("/read/")
	public void readById(long id) {
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

	@RequestMapping("/delete")
	public void delete(long id) {
		Module module = moduleService.findById(id);
		moduleService.delete(module);
	}
}
