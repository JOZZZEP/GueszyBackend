package com.example.gueszybackend.game.service;

import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.repository.GameRepository;
import com.example.gueszybackend.game.service.impl.IGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGame {
    @Autowired
    GameRepository gameRepository;
    @Override
    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(long id) {
        return gameRepository.findById(id);
    }

    @Override
    public Optional<Game> findOptionalById(long id) {
        return gameRepository.findOptionalById(id);
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }

    @Override
    public void delete(long id) {
        gameRepository.deleteById(id);
    }
    public Long getLatestInsertedId() {
        Game latestEntity = gameRepository.findTopByOrderByIdDesc();
        if (latestEntity != null) {
            return latestEntity.getId();
        } else {
            return null; // หรือค่าเริ่มต้นที่คุณต้องการ
        }
    }
}
