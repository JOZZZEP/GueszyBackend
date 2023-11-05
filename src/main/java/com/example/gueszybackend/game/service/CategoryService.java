package com.example.gueszybackend.game.service;

import com.example.gueszybackend.game.model.Category;
import com.example.gueszybackend.game.repository.CategoryRepository;
import com.example.gueszybackend.game.service.impl.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategory {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> findOptionalById(long id) {
        return categoryRepository.findOptionalById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
