package com.training.moviecatlog.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  @NoArgsConstructor
public class UserRating {
	
	private String userId;
	private List<Rating> ratings;
}