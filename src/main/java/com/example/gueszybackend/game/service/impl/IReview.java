package com.example.gueszybackend.game.service.impl;

import com.example.gueszybackend.game.model.Review;

import java.util.List;
import java.util.Optional;

public interface IReview {
    List<Review> getAllReview();
    Review findById(long id);
    Optional<Review> findOptionalById(long id);
    void save(Review review);
    void delete(long id);
}
