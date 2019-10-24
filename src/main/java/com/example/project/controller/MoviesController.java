package com.example.project.controller;


import com.example.project.models.Movie;
import com.example.project.repositories.MoviesRepository;
import com.example.project.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="movies")
public class MoviesController {

    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    //list all available movies
    @GetMapping
    public List<Movie> getAllMovies(){
        return moviesRepository.findAll();
    }

    //search movie by name
    @GetMapping(value = "/search")
    public List<Movie> searchMovie(@RequestParam String movieName){
        return moviesRepository.findByName(movieName);
    }

    //search original movies by id
    @GetMapping(value = "movies/{id}")
    public Movie FindMovieById(@PathVariable long id){
        Movie movie= moviesRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Movie with the id: "+id+"was not found")
        );
        moviesRepository.save(movie);
        return movie;
    }

    //list user's movies
    @GetMapping(value = "{NationalId}/movies")
    public List<Movie> findMoviesByUsersNationalId(@PathVariable Integer NationalId){
        return moviesRepository.findByUsers_NationalID(NationalId);
    }

    //list user's movies by id
    @GetMapping(value = "{NationalId}/movies/{id}")
    public List<Movie> findMovieByID(@PathVariable Integer NationalId,@PathVariable long Id){
        moviesRepository.findByUsers_NationalID(NationalId);
        return moviesRepository.findAllById(Id);
    }

    //update user's movie
    @PatchMapping(value = "{NationalId}/updatemovies/{id}")
    public Movie Updatemovie(@PathVariable Integer NationalId, @PathVariable long id,@RequestBody Movie movies){
        moviesRepository.findByUsers_NationalID(NationalId);
        Movie findmovie= FindMovieById(id);
        findmovie.setName(movies.getName());
        findmovie.setYearReleased(movies.getYearReleased());
        return moviesRepository.save(findmovie);
    }


}
