package com.example.gueszybackend.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "gueszy_id",nullable = false)
    private String gueszyId;

    public User(){

    }

    public User(String name, String password, String gueszyId){
        this.name = name;
        this.password = password;
        this.gueszyId = gueszyId;
    }
}
