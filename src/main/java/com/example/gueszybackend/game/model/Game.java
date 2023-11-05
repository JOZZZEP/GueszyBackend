package com.example.gueszybackend.game.model;

import com.example.gueszybackend.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "image",nullable = false)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "play",nullable = false)
    private Integer play;

    @Column(name = "access",nullable = false)
    private Integer access;

    @CreationTimestamp
    @Column(name = "create_at",nullable = false,
            updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    public Game(){

    }

    public Game(String name, Category categoryId, User userId, Integer play, Integer access) {
        this.name = name;
        this.categoryId = categoryId;
        this.userId = userId;
        this.play = play;
        this.access = access;
    }
}
