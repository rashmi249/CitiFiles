package com.training.movierating.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor  @NoArgsConstructor
public class UserRating {
	
	@Id
	@Column(name="user_id")
	private String userId;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Rating> ratings;
}
