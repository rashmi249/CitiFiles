package com.training.moviecatlog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.moviecatlog.feignclient.MovieInfoServiceProxy;
import com.training.moviecatlog.feignclient.UserRatingServiceProxy;
import com.training.moviecatlog.model.Movie;
import com.training.moviecatlog.model.MovieCatalog;
import com.training.moviecatlog.model.MovieCatalogItem;
import com.training.moviecatlog.model.Rating;
import com.training.moviecatlog.model.UserRating;

@RestController
@RequestMapping("/api/v1")
public class MovieCatlogController {
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	
	@Autowired
	MovieInfoServiceProxy  movieInfoServiceProxy;
	
	@Autowired
	UserRatingServiceProxy userRatingServiceProxy;
	
	@GetMapping("/catalog-feign/{userId}")
	public ResponseEntity<MovieCatalog> getMovieCatolg(String userId) {
		// call user Rating Service to get movie ratings given by user.
		
		//ResponseEntity<UserRating> response = restTemplate.getForEntity("http://MOVIE-RATING-SERVICE/api/v1/ratings/alexB/", UserRating.class);
		UserRating userrating= userRatingServiceProxy.getMovieRatings("alexB").getBody();
		List<Rating> ratings = userrating.getRatings();
		//MovieId Ratings
		//101 4
		// Prepare MovieCatalog
		MovieCatalog catlog = new MovieCatalog();
		catlog.setUserId("alexB");
		
		List<MovieCatalogItem> catalogItems = new ArrayList<>();
		
		
		// Call movie-info-service to get movie details
		//We need to display movie info plus ratings 
		for(Rating rating: ratings) {
			// Movie  movies =restTemplate.getForEntity("http://MOVIE-INFO-SERVICE/api/v1/movies/"+rating.getMovieId(),Movie.class).getBody();	
		Movie movies = movieInfoServiceProxy.getMovieDetails(rating.getMovieId()).getBody();
		    
		    catalogItems.add(new MovieCatalogItem(movies, rating.getRating()));
		    
		
		}
		
		catlog.setCatalogItems(catalogItems);
		
		return new ResponseEntity<MovieCatalog>(catlog, HttpStatus.OK);
		
		
	}

}
