package com.example.project.repositories;

import com.example.project.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    @Query(value = "SELECT category from categories GROUP by category", nativeQuery = true)
    List<String> groups();

    @Query(value = "SELECT name FROM movies JOIN categories_join ON movies.id = categories_join.movie_id " +
            "JOIN categories ON categories.cat_id = categories_join.category_id " +
            "WHERE categories.category = :cat and movies.movie_type = :status" , nativeQuery = true)
    List<String> movies(@Param("cat") String category,
                        @Param("status") String status);

}
