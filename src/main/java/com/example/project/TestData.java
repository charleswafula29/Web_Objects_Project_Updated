package com.example.project;

import com.example.project.repositories.MoviesRepository;
import com.example.project.repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestData implements CommandLineRunner {

    private final MoviesRepository moviesRepository;
    private final UsersRepository usersRepository;

    public TestData(MoviesRepository moviesRepository, UsersRepository usersRepository) {
        this.moviesRepository = moviesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
