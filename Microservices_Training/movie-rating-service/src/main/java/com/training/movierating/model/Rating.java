package com.training.movierating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Rating {
	@Id
	@Column(name="movie_id")
	private int movieId;
	
	private int rating;
}
