package com.example.project.repositories;

import com.example.project.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByNationalID(Integer nationalID);
}
