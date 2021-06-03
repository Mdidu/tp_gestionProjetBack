package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Employe;
import com.example.demo.domain.Projet;
import com.example.demo.repository.EmployeRepository;

@Service
@Transactional
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	EmployeRepository employeRepository;
	
	@Override
	public void add(Employe employe) {
		System.out.println(employe.getPwd());
		employeRepository.save(employe);
	}

	@Override
	public void delete(Employe employe) {
		employeRepository.delete(employe);
	}

	@Override
	public void update(Employe employe) {
		employeRepository.save(employe);
	}

	@Override
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}

	@Override
	public Employe findById(long id) {
		return employeRepository.findById(id).get();
	}

	@Override
	public List<Employe> findByProjet(Projet id) {
		return employeRepository.findByProjet(id);
	}

	@Override
	public Optional<Employe> findByMail(String mail) {
		return employeRepository.findByMail(mail);
	}

	@Override
	public boolean existsByMail(String email) {
		return employeRepository.existsByMail(email);
	}

	
}