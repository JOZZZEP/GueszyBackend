package com.example.gueszybackend.game.business;

import com.example.gueszybackend.game.json.VocabularyJson;
import com.example.gueszybackend.game.model.Vocabulary;
import com.example.gueszybackend.game.payload.VocabularyPayload;
import com.example.gueszybackend.game.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyBusiness {
    @Autowired
    VocabularyService vocabularyService;
    public List<VocabularyJson> getListVocabulary(){
        return VocabularyJson.packJsons(vocabularyService.getAllVocabulary());
    }

    public VocabularyJson getVocabularyId(long id){
        return VocabularyJson.packJson(vocabularyService.findById(id));
    }

    public void save(VocabularyPayload vocabularyPayload){
        Vocabulary vocabulary = new Vocabulary(
                vocabularyPayload.getWord(),
                vocabularyPayload.getGameId()
        );
        vocabularyService.save(vocabulary);
    }
    public void update(long id, VocabularyPayload vocabularyPayload){
        Vocabulary vocabulary = vocabularyService.findById(id);
        vocabulary.setWord(vocabularyPayload.getWord());
        vocabulary.setGameId(vocabularyPayload.getGameId());
        vocabularyService.save(vocabulary);
    }

    public void delete(long id){
        vocabularyService.delete(id);
    }
}
