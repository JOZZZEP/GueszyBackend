package com.example.gueszybackend.game.payload;

import com.example.gueszybackend.game.model.Game;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VocabularyPayload {
    private String word;
    private Integer gameId;
}
