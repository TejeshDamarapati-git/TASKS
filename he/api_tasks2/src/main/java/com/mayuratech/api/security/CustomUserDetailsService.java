package com.mayuratech.api.security;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mayuratech.api.repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		com.mayuratech.api.entity.User user = userRepository.findByEmailOrUserName(usernameOrEmail,usernameOrEmail);
		if(user == null) {
			throw new UsernameNotFoundException("User not found with the given email or username");
		}
		return new User(user.getEmail(),user.getPassword(),new ArrayList<>());
	}

}
