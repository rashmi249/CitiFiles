package com.training.movierating.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.movierating.model.UserRating;
import com.training.movierating.repository.UserRatingRepository;

@RestController
@RequestMapping("/api/v1")
public class UserRatingController {
	
	@Autowired
	private UserRatingRepository userRatingRepository;
	
	@GetMapping("/ratings/{userId}")
	public ResponseEntity<UserRating> getMovieRatings(@PathVariable String userId) {
		
		UserRating ratings = userRatingRepository.findById(userId).get();
		return new ResponseEntity<UserRating>(ratings, HttpStatus.OK);
	}
	
	@PostMapping("/ratings")
	public ResponseEntity<UserRating> saveUserRating(@RequestBody UserRating userRating) {
		UserRating savedUserRating = userRatingRepository.save(userRating);
		return new ResponseEntity<UserRating>(savedUserRating, HttpStatus.CREATED);
	}
	
	
}







