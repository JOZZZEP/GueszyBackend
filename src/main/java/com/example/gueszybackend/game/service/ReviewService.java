package com.example.gueszybackend.game.service;

import com.example.gueszybackend.game.model.Review;
import com.example.gueszybackend.game.repository.ReviewRepository;
import com.example.gueszybackend.game.service.impl.IReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReview {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Optional<Review> findOptionalById(long id) {
        return reviewRepository.findOptionalById(id);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void delete(long id) {
        reviewRepository.deleteById(id);
    }
}
