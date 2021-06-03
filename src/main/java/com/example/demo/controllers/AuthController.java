package com.example.demo.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Departement;
import com.example.demo.domain.ERole;
import com.example.demo.domain.Employe;
import com.example.demo.domain.Projet;
import com.example.demo.domain.Role;
import com.example.demo.jwt.JwtUtils;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.services.DepartementsService;
import com.example.demo.services.ProjetService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserDetailsImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeRepository userRepository;

	@Autowired
	RoleService roleService;
	
	@Autowired
	DepartementsService departementService;
	
	@Autowired
	ProjetService projetService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	

		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		if (userRepository.existsByMail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Employe user = new Employe(signUpRequest.getEmail(),
							signUpRequest.getNom(),
							signUpRequest.getPrenom(),
							 encoder.encode(signUpRequest.getPassword()));

		long idRoles = signUpRequest.getRole();
		Role roles = new Role();

		long idDepartements = signUpRequest.getDepartement();
		Departement departement = departementService.findById(idDepartements);
		
		long idProjets = signUpRequest.getProjet();
		Projet projet = projetService.findById(idProjets);
		
		if (idRoles == 2) {
			roles = roleService.findByLibelle(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		} else if(idRoles == 3) {
			roles = roleService.findByLibelle(ERole.ROLE_MODERATOR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));			
		} else {
			roles = roleService.findByLibelle(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		}

		user.setRole(roles);
		user.setDepartement(departement);
		user.setProjet(projet);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		
	}
}
