package com.example.gueszybackend.game.controller;

import com.example.gueszybackend.exception.BaseException;
import com.example.gueszybackend.game.business.ReviewBusiness;
import com.example.gueszybackend.game.json.ReviewJson;
import com.example.gueszybackend.game.payload.ReviewPayload;
import com.example.gueszybackend.game.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gueszy")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewBusiness reviewBusiness;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/review")
    public ResponseEntity<List<ReviewJson>> getAll()throws BaseException {
        return ResponseEntity.ok(reviewBusiness.getListReview());
    }

    @PostMapping("/review/insert")
    public ResponseEntity<Void> save(@RequestBody ReviewPayload reviewPayload)throws BaseException{
        reviewBusiness.saveReview(reviewPayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
