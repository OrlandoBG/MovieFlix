package com.devsuperior.movieflix.dto;

public class UserPasswordDTO extends UserDTO{
	
	private String password;
	
	public UserPasswordDTO() {
		super();
	}

	public UserPasswordDTO(Long id, String name, String email, String password) {
		super(id, name, email);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
