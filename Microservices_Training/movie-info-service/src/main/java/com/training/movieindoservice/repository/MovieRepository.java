package com.training.movieindoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.movieindoservice.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
