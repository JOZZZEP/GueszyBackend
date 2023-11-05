package com.example.gueszybackend.game.repository;

import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.model.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    Vocabulary findById(long id);
    Optional<Vocabulary> findOptionalById(long id);
    List<Vocabulary> findByGameId(Game game);
}
