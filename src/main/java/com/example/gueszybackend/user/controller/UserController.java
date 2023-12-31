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

    @PostMapping(value = "/user/register")
    public ResponseEntity<Void> save(@RequestBody UserPayload userPayload){
        if(userService.findByName(userPayload.getName()) == null){
            userBusiness.saveUser(userPayload);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<UserJson> update(@PathVariable("id") long id, @RequestBody UserPayload userPayload) {
        if(userService.findByName(userPayload.getName()) == null){
            userBusiness.updateUser(id, userPayload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

    @PostMapping(value = "/user/login")
    public ResponseEntity<UserJson>
    login(@RequestBody UserPayload userPayload) throws BaseException{
        return ResponseEntity.ok(userBusiness.login(userPayload));
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<Void>
    delete(@PathVariable("id") long id) throws BaseException{
        userBusiness.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
