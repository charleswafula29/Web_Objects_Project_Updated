package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id",scope = Movie.class)
@Table(name = "movies")
public class Movie {


    //auto increment id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_released")
    private String yearReleased;

    @Column(name = "type")
    private String type;

    //creating a many movies to one user relationship
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "users_id")
    private Users users;

    //ceating a many movies to many categories relationship
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "categories_join", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "catId"))
    private Set<Categories> categories = new HashSet<>();

    //main constructor
    public Movie(String name, String yearReleased, String type, Users users, Set<Categories> categories) {
        this.name = name;
        this.yearReleased = yearReleased;
        this.type = type;
        this.users = users;
        this.categories = categories;
    }

    //default constructor
    public Movie() {
    }

    public long getId() {
        return id;
    }

    public long getId(long id) { return this.id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearReleased='" + yearReleased + '\'' +
                ", type='" + type + '\'' +
                ", users=" + users +
                ", categories=" + categories +
                '}';
    }
}
