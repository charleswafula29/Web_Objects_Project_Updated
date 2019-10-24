package com.example.project.repositories;

import com.example.project.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByUsers_NationalID (Integer NationalId);
    List<Movie> findByName (String name);
    List<Movie> findAllById (Long id);

}
