package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Projet;
import com.example.demo.repository.ProjetRepository;

@Service
@Transactional
public class ProjetServiceImpl implements ProjetService {

	@Autowired
	ProjetRepository projetRepository;
	
	@Override
	public void add(Projet projet) {
		projetRepository.save(projet);
	}

	@Override
	public void delete(Projet projet) {
		projetRepository.delete(projet);
	}

	@Override
	public void update(Projet projet) {
		projetRepository.save(projet);
	}

	@Override
	public List<Projet> findAll() {
		return projetRepository.findAll();
	}

	@Override
	public Projet findById(long id) {
		return projetRepository.findById(id).get();
	}

}