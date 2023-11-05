package com.example.gueszybackend.game.repository;

import com.example.gueszybackend.game.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(long id);
    Optional<Category> findOptionalById(long id);
}
