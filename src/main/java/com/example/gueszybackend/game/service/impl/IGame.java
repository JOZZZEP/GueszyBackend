package com.example.gueszybackend.game.service.impl;

import com.example.gueszybackend.game.model.Game;

import java.util.List;
import java.util.Optional;

public interface IGame {
    List<Game> getAllGame();
    Game findById(long id);
    Optional<Game> findOptionalById(long id);
    void save(Game game);
    void delete(long id);
}
