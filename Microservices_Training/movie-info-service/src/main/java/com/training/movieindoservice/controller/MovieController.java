package com.training.movieindoservice.controller;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.movieindoservice.exception.MovieNotFoundException;
import com.training.movieindoservice.model.Movie;
import com.training.movieindoservice.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<Movie> getMovieDetails(@PathVariable int movieId){
	Movie movie=movieRepository.findById(movieId)
			   .orElseThrow(()->new MovieNotFoundException("Movie Not Found"));
	return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<Object> handlemovieNotfoundException(MovieNotFoundException ex){
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/movies")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
	Movie saveMovie =	movieRepository.save(movie);		
		return new ResponseEntity<Movie>(saveMovie,HttpStatus.CREATED);
		
	}
}
