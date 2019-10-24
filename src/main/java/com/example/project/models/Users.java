package com.example.project.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    //auto increment ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "names")
    private String name;

    @Column(name = "nationalID")
    private Integer nationalID;

    //creating a one user to many movies relationship
    @OneToMany(mappedBy ="users")
    private List<Movie> movies;

    //default constructor
    public Users() {
    }

    public Users(String name, Integer nationalID, List<Movie> movies) {
        this.name = name;
        this.nationalID = nationalID;
        this.movies = movies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNationalID() {
        return nationalID;
    }

    public void setNationalID(Integer nationalID) {
        this.nationalID = nationalID;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ID_number=" + nationalID +
                ", movies=" + movies +
                '}';
    }
}
