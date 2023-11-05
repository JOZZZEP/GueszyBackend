package com.example.gueszybackend.game.payload;

import com.example.gueszybackend.game.model.Category;
import com.example.gueszybackend.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GamePayload {
    private String name;
    private String image;
    private Category categoryId;
    private User userId;
    private Integer play;
    private Integer access;
}
