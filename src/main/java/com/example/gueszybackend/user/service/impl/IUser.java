package com.example.gueszybackend.user.service.impl;

import com.example.gueszybackend.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUser {
        List<User> getAllUsers();
        User findById(long id);
        Optional<User> findOptionalById(long id);
        User findByGueszyId(String gueszyId);
        void save(User user);
        void deleteById(long id);
}
