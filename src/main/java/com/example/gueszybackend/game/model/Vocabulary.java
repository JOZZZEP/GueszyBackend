package com.example.gueszybackend.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vocabulary")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vocab_id")
    private Long id;

    @Column(name = "word",nullable = false)
    private String word;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;

    public Vocabulary() {
    }

    public Vocabulary(String word, Game gameId) {
        this.word = word;
        this.gameId = gameId;
    }
}
