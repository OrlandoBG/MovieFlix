package com.devsuperior.movieflix.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.Role;
import com.devsuperior.movieflix.entities.User;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<>();
	private List<Review> reviews = new ArrayList<>();
	
	public UserDTO(Long id, String name, String email, String password, Set<Role> roles, List<Review> reviews) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.reviews = reviews;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
	}
	
	
}
