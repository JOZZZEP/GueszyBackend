package com.example.gueszybackend.game.service;

import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.model.Vocabulary;
import com.example.gueszybackend.game.repository.VocabularyRepository;
import com.example.gueszybackend.game.service.impl.IVocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VocabularyService implements IVocabulary {
    @Autowired
    VocabularyRepository vocabularyRepository;
    @Override
    public List<Vocabulary> getAllVocabulary() {
        return vocabularyRepository.findAll();
    }

    @Override
    public Vocabulary findById(long id) {
        return vocabularyRepository.findById(id);
    }

    @Override
    public Optional<Vocabulary> findOptionalById(long id) {
        return vocabularyRepository.findOptionalById(id);
    }

    @Override
    public void save(Vocabulary vocabulary) {
        vocabularyRepository.save(vocabulary);
    }

    @Override
    public void delete(long id) {
        vocabularyRepository.deleteById(id);
    }

    public List<Vocabulary> getByGameId(Game game){
       return vocabularyRepository.findAllByGameId(game);
    }
}
