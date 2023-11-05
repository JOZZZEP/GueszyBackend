package com.example.gueszybackend.game.business;

import com.example.gueszybackend.game.json.ReviewJson;
import com.example.gueszybackend.game.model.Review;
import com.example.gueszybackend.game.payload.ReviewPayload;
import com.example.gueszybackend.game.service.GameService;
import com.example.gueszybackend.game.service.ReviewService;
import com.example.gueszybackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewBusiness {
    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;

    public List<ReviewJson> getListReview(){
        return ReviewJson.packJsons(reviewService.getAllReview());
    }

    public void saveReview(ReviewPayload reviewPayload){
        Review review = new Review(
                userService.findById(reviewPayload.getUserId()),
                gameService.findById(reviewPayload.getGameId()),
                reviewPayload.getPoint());
        reviewService.save(review);
    }

}
