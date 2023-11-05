package com.example.gueszybackend.game.service.impl;

import com.example.gueszybackend.game.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategory {

    List<Category> getAllCategory();
    Category findById(long id);
    Optional<Category> findOptionalById(long id);
    void save(Category category);
    void delete(long id);
}
