package com.hotelapp;

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
			return	new User("Raju","$2a$10$ATK9Bn7xZrmPesr4NswBtuqOq6/XkVR9t.SEZ/hh2u5KK0z6EDuCC",
					new ArrayList<>());
		}else
		 throw new UsernameNotFoundException("username not found");
	}	 

}
