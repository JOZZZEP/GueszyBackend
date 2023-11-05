package com.example.gueszybackend.game.business;

import com.example.gueszybackend.game.json.GameJson;
import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.payload.GamePayload;
import com.example.gueszybackend.game.service.CategoryService;
import com.example.gueszybackend.game.service.GameService;
import com.example.gueszybackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameBusiness {
    @Autowired
    GameService gameService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    public List<GameJson> getListGame(){
        return GameJson.packJsons(gameService.getAllGame());
    }

    public GameJson getGameId(long id){
        return GameJson.packJson(gameService.findById(id));
    }

    public void save(GamePayload gamePayload){
        Game game = new Game(
                gamePayload.getName(),
                categoryService.findById(gamePayload.getCategoryId()),
                userService.findById(gamePayload.getUserId()),
                gamePayload.getPlay(),
                gamePayload.getAccess(),
                gamePayload.getImage()
        );
        gameService.save(game);
    }
    public void update(long id, GamePayload gamePayload){
        Game game = gameService.findById(id);
        game.setName(gamePayload.getName());
        game.setCategoryId(categoryService.findById(gamePayload.getCategoryId()));
        game.setUserId(userService.findById(gamePayload.getUserId()));
        game.setPlay(gamePayload.getPlay());
        game.setAccess(gamePayload.getAccess());
        gameService.save(game);
    }

    public void delete(long id){
        gameService.delete(id);
    }
}