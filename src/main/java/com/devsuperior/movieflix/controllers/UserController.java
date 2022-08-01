package com.devsuperior.movieflix.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> getProfile(){
		return null;
	}

}
