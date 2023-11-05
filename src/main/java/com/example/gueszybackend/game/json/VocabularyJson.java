package com.example.gueszybackend.game.json;

import com.example.gueszybackend.game.model.Category;
import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.model.Vocabulary;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VocabularyJson {
    private Long id;
    private String word;
    private Game gameId;

    public static VocabularyJson packJson(Vocabulary vocabulary){
        VocabularyJson vocabularyJson = new VocabularyJson();
        vocabularyJson.setId(vocabulary.getId());
        vocabularyJson.setWord(vocabulary.getWord());
        vocabularyJson.setGameId(vocabulary.getGameId());
        return vocabularyJson;
    }

    public static List<VocabularyJson> packJsons(List<Vocabulary> vocabularies){
        List<VocabularyJson> vocabularyJsons = new ArrayList<>();
        for (Vocabulary vocabulary : vocabularies){
            vocabularyJsons.add(packJson(vocabulary));
        }
        return vocabularyJsons;
    }
}
