package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repository.GenreRepository;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;


@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findByGenre(Long GenreId,Pageable pageable){
		authService.validateMemberOrVisitor();
		Genre genre = (GenreId == 0) ? null : genreRepository.getOne(GenreId);
		Page<MovieDTO> pageOfMovies = repository.findByGenre(genre, pageable);
		return pageOfMovies;
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		authService.validateMemberOrVisitor();
		Optional<Movie> obj = repository.findById(id);
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		MovieDTO dto = new MovieDTO(movie);
		return dto;
	}

}
