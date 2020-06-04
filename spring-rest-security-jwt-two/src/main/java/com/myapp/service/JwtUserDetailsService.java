package com.myapp.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("Raju")) {
			return new User("Raju","$2a$10$6qSPmVD8Eep3z0lA6vIMQOiPNFWaxrjEbkPsA8dpa7Ltf.rM9rfVy",new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User deos not exist");
		}
		
	}

	
}
