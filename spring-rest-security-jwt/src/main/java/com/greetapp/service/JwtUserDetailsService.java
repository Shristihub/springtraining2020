package com.greetapp.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("Priya")) {
		return new User("Priya",
				        "$2a$10$RmbVuzPeJWSXTLtXfTbLMOaWqnsnPWgLP3EZ.E2JJtuVhbpXxjeQe",
				        new  ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Username does note exist");
		}
	}

}
