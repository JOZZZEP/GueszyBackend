package com.example.gueszybackend.game.controller;

import com.example.gueszybackend.exception.BaseException;
import com.example.gueszybackend.game.business.GameBusiness;
import com.example.gueszybackend.game.business.VocabularyBusiness;
import com.example.gueszybackend.game.json.CategoryJson;
import com.example.gueszybackend.game.json.GameJson;
import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.payload.GamePayload;
import com.example.gueszybackend.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gueszy")
public class GameController {
    @Autowired
    GameBusiness gameBusiness;
    @Autowired
    GameService gameService;
    @Autowired
    VocabularyBusiness vocabularyBusiness;

    @PostMapping(value = "/game/insert")
    public ResponseEntity<Void> save(@RequestBody GamePayload gamePayload){
        gameBusiness.save(gamePayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/game/update/{id}")
    public ResponseEntity<CategoryJson> update(@PathVariable("id") long id, @RequestBody GamePayload gamePayload) {
        Optional<Game> game = gameService.findOptionalById(id);
        if (game.isPresent()) {
            gameBusiness.update(game.get().getId(), gamePayload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/game")
    public ResponseEntity<List<GameJson>> getAll() throws BaseException {
        return ResponseEntity.ok(gameBusiness.getListGame());
    }

    @GetMapping(value = "/game/{id}")
    public ResponseEntity<GameJson>
    getById(@PathVariable("id") long id) throws BaseException{
        return ResponseEntity.ok(gameBusiness.getGameId(id));
    }

    @DeleteMapping(value = "/game/delete/{id}")
    public ResponseEntity<Void>
    delete(@PathVariable("id") long id)throws BaseException{
        vocabularyBusiness.deleteByGameId(id);
        gameBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
