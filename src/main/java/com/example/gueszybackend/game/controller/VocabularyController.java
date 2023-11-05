package com.example.gueszybackend.game.controller;

import com.example.gueszybackend.exception.BaseException;
import com.example.gueszybackend.game.business.VocabularyBusiness;
import com.example.gueszybackend.game.json.CategoryJson;
import com.example.gueszybackend.game.json.VocabularyJson;
import com.example.gueszybackend.game.model.Vocabulary;
import com.example.gueszybackend.game.payload.VocabularyPayload;
import com.example.gueszybackend.game.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gueszy")
public class VocabularyController {
    @Autowired
    VocabularyBusiness vocabularyBusiness;
    @Autowired
    VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }


    @PostMapping(value = "/vocabulary/insert")
    public ResponseEntity<Void> save(@RequestBody VocabularyPayload vocabularyPayload){
        vocabularyBusiness.save(vocabularyPayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/vocabulary/update/{id}")
    public ResponseEntity<CategoryJson> update(@PathVariable("id") long id, @RequestBody VocabularyPayload vocabularyPayload) {
        Optional<Vocabulary> vocabulary = vocabularyService.findOptionalById(id);
        if (vocabulary.isPresent()) {
            vocabularyBusiness.update(vocabulary.get().getId(), vocabularyPayload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/vocabulary")
    public ResponseEntity<List<VocabularyJson>> getAll() throws BaseException {
        return ResponseEntity.ok(vocabularyBusiness.getListVocabulary());
    }


    @GetMapping(value = "/vocabulary/{id}")
    public ResponseEntity<VocabularyJson>
    getById(@PathVariable("id") long id) throws BaseException{
        return ResponseEntity.ok(vocabularyBusiness.getVocabularyId(id));
    }

    @GetMapping(value = "/vocabulary/gameId/{id}")
    public ResponseEntity<List<VocabularyJson>>
    getByGameId(@PathVariable("id") long id)throws BaseException{
        return ResponseEntity.ok(vocabularyBusiness.getByGameId(id));
    }

    @DeleteMapping(value = "/vocabulary/delete/gameId/{id}")
    public ResponseEntity<Void>
    deleteByGameId(@PathVariable("id")long id)throws BaseException{
        vocabularyBusiness.deleteByGameId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/vocabulary/{id}")
    public ResponseEntity<Void>
    deleteById(@PathVariable("id") long id)throws BaseException{
        vocabularyBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
