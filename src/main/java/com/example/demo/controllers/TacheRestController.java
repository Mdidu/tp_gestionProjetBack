package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Tache;
import com.example.demo.services.TacheService;

public class TacheRestController {
	
	@Autowired
	TacheService tacheService;
	
	@RequestMapping("/read")
	public void read() {
		List<Tache> listTaches = new ArrayList<Tache>();
		listTaches = tacheService.findAll();
	}
	
	@RequestMapping("/read/")
	public void readById(long id) {
		Tache tache = new Tache();
		tache = tacheService.findById(id);
	}

	@RequestMapping("/add")
	public void add(Tache tache) {
		tacheService.add(tache);
	}

	@RequestMapping("/update")
	public void update(Tache tache) {
		tacheService.update(tache);
	}

	@RequestMapping("/delete")
	public void delete(long id) {
		Tache tache = tacheService.findById(id);
		tacheService.delete(tache);
	}
}
