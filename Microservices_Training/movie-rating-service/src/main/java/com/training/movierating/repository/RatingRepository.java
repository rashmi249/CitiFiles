package com.training.movierating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.movierating.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{

}
