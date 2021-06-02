package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt {
	
	public static BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
