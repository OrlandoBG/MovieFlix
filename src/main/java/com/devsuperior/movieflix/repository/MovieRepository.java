package com.devsuperior.movieflix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
	
	@Query("SELECT obj "
			+ "FROM Movie obj "
			+ "WHERE (:genre IS NULL OR obj.genre = :genre) "
			+ "ORDER BY obj.title")	
	Page<Movie> findByGenre(Genre genre, Pageable pageable);
	
}
