package com.mayuratech.api.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
	
	
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		System.out.println(passwordEncoder().encode("krishna"));
	}
}


