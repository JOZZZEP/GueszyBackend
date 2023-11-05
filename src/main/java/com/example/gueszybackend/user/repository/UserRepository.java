package com.example.gueszybackend.user.repository;

import com.example.gueszybackend.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);
    Optional<User> findOptionalById(long id);
    User findByGueszyId(String gueszyId);

    User findByNameAndPassword(String name,String password);
}
