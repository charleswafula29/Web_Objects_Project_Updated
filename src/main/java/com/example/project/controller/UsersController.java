package com.example.project.controller;

import com.example.project.NotFoundException;
import com.example.project.models.Categories;
import com.example.project.models.Movie;
import com.example.project.models.Users;
import com.example.project.repositories.MoviesRepository;
import com.example.project.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UsersController {

    private final MoviesRepository moviesRepository;
    private final UsersRepository usersRepository;

    public UsersController(MoviesRepository moviesRepository, UsersRepository usersRepository) {
        this.moviesRepository = moviesRepository;
        this.usersRepository = usersRepository;
    }

    //list all available users
    @GetMapping
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    //find user by Id
    @GetMapping(value = "{id}")
    public Users findUserByID(@PathVariable long id) {
        Users users = usersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No user with ID: " + id + " was found")
        );
        usersRepository.save(users);
        return users;
    }

    //find user by their nationalId
    @GetMapping(value = "/UserNationalId/{nationalId}")
    public Users findUserByNationalId(@PathVariable Integer nationalId) {
        return usersRepository.findByNationalID(nationalId);
    }

    //create new user
    @PostMapping
    public Users createUser(@RequestBody Users users) {
        return usersRepository.save(users);
    }

    //delete existing user
    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable long id) {
        usersRepository.deleteById(id);
    }


    //get particular user's movies
    @GetMapping(value = "{nationalId}/movies")
    public List<Movie> findMoviesByUserNationalID(@PathVariable Integer nationalId) {
        return moviesRepository.findByUsers_NationalID(nationalId);
    }

    //user to create new movie
    @PostMapping(value = "{id}/movies")
    public Movie createAMovie(@PathVariable long id,
                               @RequestParam String category,
                               @RequestParam String movieName,
                              @RequestParam String yearReleased) {
        HashSet<Categories> categories = new HashSet<>();
        Categories catValues = new Categories();
        catValues.setCategory_name(category);
        categories.add(catValues);
        Users user = findUserByID(id);
        Movie movies = new Movie();
        movies.setCategories(categories);
        movies.setName(movieName);
        movies.setUsers(user);
        movies.setYearReleased(yearReleased);
        movies.setType("Suggested");
        return moviesRepository.save(movies);
    }

    //delete existing movie
    @DeleteMapping(value = "{nationalId}/movies/{id}")
    public void deleteCourse(@PathVariable long id, @PathVariable Integer nationalId) {
        moviesRepository.findByUsers_NationalID(nationalId);
        moviesRepository.deleteById(id);
    }


}
