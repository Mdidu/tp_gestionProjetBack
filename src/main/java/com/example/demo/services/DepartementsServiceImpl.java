package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Departement;
import com.example.demo.repository.DepartementsRepository;

@Service
@Transactional
public class DepartementsServiceImpl implements DepartementsService {

	@Autowired
	DepartementsRepository departementsRepository;
	
	@Override
	public void add(Departement departement) {
		departementsRepository.save(departement);
	}

	@Override
	public void delete(Departement departement) {
		departementsRepository.delete(departement);
	}

	@Override
	public void update(Departement departement) {
		departementsRepository.save(departement);
	}

	@Override
	public List<Departement> findAll() {
		return departementsRepository.findAll();
	}

	@Override
	public Departement findById(long id) {
		return departementsRepository.findById(id).get();
	}

}