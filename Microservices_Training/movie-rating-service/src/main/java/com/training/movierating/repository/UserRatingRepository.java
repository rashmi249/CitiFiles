package com.training.movierating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.movierating.model.UserRating;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, String>{

}
