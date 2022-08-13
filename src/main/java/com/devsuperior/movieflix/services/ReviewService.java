package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findReviews(Long movieId){
		Movie movie = (movieId == 0) ? null : movieRepository.getOne(movieId);
		List<Review> listOfReview = repository.findReviews(movie);
		return listOfReview.stream().map(review -> new ReviewDTO(review,review.getUser())).collect(Collectors.toList());
	}
	
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
