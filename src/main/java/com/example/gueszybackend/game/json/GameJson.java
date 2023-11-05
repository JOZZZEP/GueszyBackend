package com.example.gueszybackend.game.json;

import com.example.gueszybackend.game.model.Category;
import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameJson {
    private Long id;
    private String name;
    private String image;
    private Category categoryId;
    private User userId;
    private Integer play;
    private Integer access;
    private LocalDateTime createAt;

    public static GameJson packJson(Game game){
        GameJson gameJson = new GameJson();
        gameJson.setId(game.getId());
        gameJson.setName(game.getName());
        gameJson.setImage(game.getImage());
        gameJson.setCategoryId(game.getCategoryId());
        gameJson.setUserId(game.getUserId());
        gameJson.setPlay(game.getPlay());
        gameJson.setAccess(game.getAccess());
        gameJson.setCreateAt(game.getCreateAt());
        return gameJson;
    }

    public static List<GameJson> packJsons(List<Game> games){
        List<GameJson> gameJsons = new ArrayList<>();
        for (Game game : games){
            gameJsons.add(packJson(game));
        }
        return gameJsons;
    }
}
