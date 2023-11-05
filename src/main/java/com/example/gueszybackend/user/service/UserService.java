package com.example.gueszybackend.user.service;

import com.example.gueszybackend.user.model.User;
import com.example.gueszybackend.user.repository.UserRepository;
import com.example.gueszybackend.user.service.impl.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUser {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByGueszyId(String gueszyId) {
        return userRepository.findByGueszyId(gueszyId);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findOptionalById(long id){
        return userRepository.findOptionalById(id);
    }

    public User login(String name,String password){
        return userRepository.findByNameAndPassword(name,password);
    }
}
