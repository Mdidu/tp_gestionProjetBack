package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Tache;
import com.example.demo.repository.TacheRepository;

@Service
@Transactional
public class TacheServiceImpl implements TacheService {

	@Autowired
	TacheRepository tacheRepository;
	
	@Override
	public void add(Tache tache) {
		tacheRepository.save(tache);
	}

	@Override
	public void delete(Tache tache) {
		tacheRepository.delete(tache);
	}

	@Override
	public void update(Tache tache) {
		tacheRepository.save(tache);
	}

	@Override
	public List<Tache> findAll() {
		return tacheRepository.findAll();
	}

	@Override
	public Tache findById(long id) {
		return tacheRepository.findById(id).get();
	}

}