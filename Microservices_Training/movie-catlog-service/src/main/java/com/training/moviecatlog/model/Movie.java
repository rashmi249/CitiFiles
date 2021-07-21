package com.training.moviecatlog.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Movie {
	
	private int movieId;
	private String title;
	private String imageUrl;
	private int releaseYear;
	private List<Cast> casts;
	
}