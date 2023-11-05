package com.example.gueszybackend.user.business;

import com.example.gueszybackend.user.json.UserJson;
import com.example.gueszybackend.user.model.User;
import com.example.gueszybackend.user.payload.UserPayload;
import com.example.gueszybackend.user.service.UserService;
import com.example.gueszybackend.util.GueszyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusiness {
    @Autowired
    UserService userService;

    public List<UserJson> getListUsers(){
        return UserJson.packJsons(userService.getAllUsers());
    }

    public UserJson getUserId(long id){
        return UserJson.packJson(userService.findById(id));
    }

    public UserJson getUserByGueszyId(String gueszyId){
        return UserJson.packJson(userService.findByGueszyId(gueszyId));
    }

    public void saveUser(UserPayload userPayload){
        User user = new User(userPayload.getName(), userPayload.getPassword(), GueszyCode.generate());
        userService.save(user);
    }

    public void updateUser(long id, UserPayload userPayload){
        User user = userService.findById(id);
        user.setName(userPayload.getName());
        user.setPassword(userPayload.getPassword());
        userService.save(user);
    }

    public void deleteUser(long id){
        userService.deleteById(id);
    }
}
