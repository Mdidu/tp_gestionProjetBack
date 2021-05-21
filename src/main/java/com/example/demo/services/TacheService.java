package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Module;
import com.example.demo.domain.Tache;

public interface TacheService extends GlobalService<Tache> {

	List<Tache> findByModule(Module module);

}
