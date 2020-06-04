package com.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.config.JwtRequestFilter;
import com.myapp.config.JwtTokenUtil;
import com.myapp.models.JwtResponse;
import com.myapp.models.JwtUser;
import com.myapp.service.JwtUserDetailsService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	AuthenticationManager authManager;
	@Autowired
	JwtUserDetailsService jwtUserDetailsService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtUser user)throws Exception{
		authenticate(user.getUsername(),user.getPassword());
		UserDetails details = jwtUserDetailsService.loadUserByUsername(user.getUsername());
		String token = jwtTokenUtil.generateToken(details);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password)throws Exception {
		try {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		
	}
	
	
	
}
