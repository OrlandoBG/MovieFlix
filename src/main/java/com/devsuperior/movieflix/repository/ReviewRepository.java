package com.devsuperior.movieflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

@Repository
public interface ReviewRepository extends  JpaRepository<Review, Long>{
	
	@Query("SELECT obj FROM Review obj "
			+ "WHERE (:movie IS NULL OR obj.movie = :movie)")
	List<Review> findReviews(Movie movie);
	
}
