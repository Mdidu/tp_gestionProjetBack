package com.example.demo.services;

import java.util.Optional;

import com.example.demo.domain.ERole;
import com.example.demo.domain.Role;

public interface RoleService extends GlobalService<Role> {

	Optional<Role> findByLibelle(ERole name);
}
