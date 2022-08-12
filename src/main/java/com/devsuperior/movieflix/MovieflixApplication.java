package com.devsuperior.movieflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.movieflix.repository.MovieRepository;

@SpringBootApplication
public class MovieflixApplication {

	@Autowired
	MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieflixApplication.class, args);
	}



}
