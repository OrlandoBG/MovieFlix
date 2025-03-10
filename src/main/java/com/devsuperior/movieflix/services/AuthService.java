package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	public void validateMemberOrVisitor() {
		User user = authenticated();
		if(!(user.hasRole("ROLE_VISITOR") || user.hasRole("ROLE_MEMBER"))){
			throw new ForbiddenException("Access denied");
		}	
	}
	
	public void validateMember() {
		User user = authenticated();
		if(user.hasRole("ROLE_VISITOR")) {
			throw new ForbiddenException("Access denied");
		}
	}
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = userRepository.findByEmail(username);
			return user;
		}
		catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
}
