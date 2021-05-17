package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Role;
import com.example.demo.services.RoleService;
import com.example.demo.services.RoleServiceImpl;

@SpringBootApplication
public class GestionProjetBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionProjetBackApplication.class, args);
	}

}
