package com.training.moviecatlog.feignclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.moviecatlog.model.Movie;


@FeignClient(name="movie-info-service")
public interface MovieInfoServiceProxy {

	
	@GetMapping("api/v1/movies/{movieId}")
	public ResponseEntity<Movie> getMovieDetails(@PathVariable int movieId);
}
