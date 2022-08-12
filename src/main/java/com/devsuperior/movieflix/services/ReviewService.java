package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		authService.validateMember();
		User user = authService.authenticated();
		Review review = dtoToReview(dto);
		review.setUser(user);
		repository.save(review);
		return new ReviewDTO(review, user);
	}
	
	public Review dtoToReview(ReviewDTO dto) {
		Review review = new Review();
		review.setId(dto.getId());
		review.setText(dto.getText());
		review.setMovie(new Movie(dto.getMovieId(),null,null,null,null,null,null));
		return review;
	}

}
