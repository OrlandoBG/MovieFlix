package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.UserRepository;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public UserDTO authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = userRepository.findByEmail(username);
			UserDTO dto = new UserDTO(user);
			return dto;
		}
		catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
}
