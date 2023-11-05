package com.example.gueszybackend.game.repository;

import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findById(long id);
    Optional<Game> findOptionalById(long id);
    List<Game> findByUserId(User user);
    Game findTopByOrderByIdDesc();
}
