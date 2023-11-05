package com.example.gueszybackend.user.controller;

import com.example.gueszybackend.exception.BaseException;
import com.example.gueszybackend.user.business.UserBusiness;
import com.example.gueszybackend.user.json.UserJson;
import com.example.gueszybackend.user.model.User;
import com.example.gueszybackend.user.payload.UserPayload;
import com.example.gueszybackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gueszy")
public class UserController {
    @Autowired
    UserBusiness userBusiness;

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/insert")
    public ResponseEntity<Void> save(@RequestBody UserPayload userPayload){
        userBusiness.saveUser(userPayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<UserJson> update(@PathVariable("id") long id, @RequestBody UserPayload userPayload) {
        Optional<User> user = userService.findOptionalById(id);
        if (user.isPresent()) {
            userBusiness.updateUser(user.get().getId(), userPayload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<UserJson>> getAll() throws BaseException {
        return ResponseEntity.ok(userBusiness.getListUsers());
    }


    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserJson>
    getById(@PathVariable("id") long id) throws BaseException{
        return ResponseEntity.ok(userBusiness.getUserId(id));
    }
}
