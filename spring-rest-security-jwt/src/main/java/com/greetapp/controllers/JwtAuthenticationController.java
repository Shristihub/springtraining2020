package com.greetapp.controllers;

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

import com.greetapp.config.JwtTokenUtil;
import com.greetapp.models.JwtRequest;
import com.greetapp.models.JwtResponse;
import com.greetapp.service.JwtUserDetailsService;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	private JwtUserDetailsService jwtAuthenticationService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception{
		 authenticate(authRequest.getUsername(),authRequest.getPassword());
		 UserDetails userDetails = 
				 jwtAuthenticationService.loadUserByUsername(authRequest.getUsername());
		 String token = jwtTokenUtil.generateToken(userDetails);
		 return ResponseEntity.ok(new JwtResponse(token));
			
	}

	private void authenticate(String username, String password) throws Exception {
		try {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
