package com.example.gueszybackend.game.repository;

import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.model.Review;
import com.example.gueszybackend.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findById(long id);
    Optional<Review> findOptionalById(long id);
    List<Review> findByUserId(User user);
    List<Review> findByGameId(Game game);
}
