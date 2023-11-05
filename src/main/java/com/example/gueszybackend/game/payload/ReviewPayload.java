package com.example.gueszybackend.game.payload;

import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewPayload {
    private User userId;
    private Game gameId;
    private Integer point;
}
