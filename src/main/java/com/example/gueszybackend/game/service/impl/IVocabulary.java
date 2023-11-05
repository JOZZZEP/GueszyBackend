package com.example.gueszybackend.game.service.impl;

import com.example.gueszybackend.game.model.Vocabulary;

import java.util.List;
import java.util.Optional;

public interface IVocabulary {
    List<Vocabulary> getAllVocabulary();
    Vocabulary findById(long id);
    Optional<Vocabulary> findOptionalById(long id);
    void save(Vocabulary vocabulary);
    void delete(long id);
}
