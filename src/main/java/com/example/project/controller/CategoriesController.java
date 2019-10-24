package com.example.project.controller;


import com.example.project.models.Categories;
import com.example.project.repositories.CategoriesRepository;
import com.example.project.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="categories")
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;

    public CategoriesController(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    //list all categories
    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    //list all category groups
    @GetMapping(value = "groups")
    public List<String> getAllCategoryGroups() {
        return categoriesRepository.groups();
    }

    //list all movies in one category
    @GetMapping(value = "movies/{Category}")
    public List<String> getAllMovies(@PathVariable String Category, @RequestParam String status) {
        return categoriesRepository.movies(Category,status);
    }

    //get a category by its id
    @GetMapping(value = "{id}")
    public Categories findCategoryByID(@PathVariable Long id){
        Categories categories = categoriesRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No category with ID: " + id + " was found")
        );
        categoriesRepository.save(categories);
        return categories;
    }

}
