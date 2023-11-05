package com.example.gueszybackend.game.model;

import com.example.gueszybackend.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Game gameId;

    @Column(name = "point",nullable = false)
    private Integer point;

    public Review() {
    }

    public Review(User userId, Game gameId, Integer point) {
        this.userId = userId;
        this.gameId = gameId;
        this.point = point;
    }
}
