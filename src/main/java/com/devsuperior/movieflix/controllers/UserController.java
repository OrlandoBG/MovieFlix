package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.AuthService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private AuthService service;
	
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> getProfile(){
		UserDTO UserDTO = service.authenticated();
		return ResponseEntity.ok().body(UserDTO);
		
	}

}
