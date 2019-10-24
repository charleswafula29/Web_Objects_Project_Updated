package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "catId",scope = Categories.class)
@Table(name = "categories")
public class Categories {

    //auto increment id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long catId;

    @Column(name = "category_name")
    private String category_name;

    //creating a many categories to many movies relationship
    @ManyToMany(mappedBy = "categories")
    private Set<Movie> movies = new HashSet<>();

    //default constructor
    public Categories() {
    }

    //main constructor
    public Categories(String category_name, Set<Movie> movies) {
        this.category_name = category_name;
        this.movies = movies;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoryId=" + catId +
                ", category_name='" + category_name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
