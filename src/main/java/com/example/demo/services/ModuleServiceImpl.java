package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Module;
import com.example.demo.repository.ModuleRepository;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleRepository moduleRepository;
	
	@Override
	public void add(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public void delete(Module module) {
		moduleRepository.delete(module);
	}

	@Override
	public void update(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public List<Module> findAll() {
		return moduleRepository.findAll();
	}

	@Override
	public Module findById(long id) {
		return moduleRepository.findById(id).get();
	}

}