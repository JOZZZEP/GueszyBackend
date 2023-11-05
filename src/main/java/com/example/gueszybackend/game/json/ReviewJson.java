package com.example.gueszybackend.game.json;

import com.example.gueszybackend.game.model.Game;
import com.example.gueszybackend.game.model.Review;
import com.example.gueszybackend.user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReviewJson {
    private Long id;
    private User userId;
    private Game gameId;
    private Integer point;

    public static ReviewJson packJson(Review review){
        ReviewJson reviewJson = new ReviewJson();
        reviewJson.setId(review.getId());
        reviewJson.setUserId(review.getUserId());
        reviewJson.setGameId(review.getGameId());
        reviewJson.setPoint(review.getPoint());
        return reviewJson;
    }

    public static List<ReviewJson> packJsons(List<Review> reviews){
        List<ReviewJson> reviewJsons = new ArrayList<>();
        for (Review review : reviews){
            reviewJsons.add(packJson(review));
        }
        return reviewJsons;
    }
}
