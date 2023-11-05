package com.example.gueszybackend.user.json;

import com.example.gueszybackend.user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserJson {
    private long id;
    private String name;
    private String password;
    private String gueszyId;

    public static UserJson packJson(User user){
        UserJson userJson = new UserJson();
        userJson.setId(user.getId());
        userJson.setName(user.getName());
        userJson.setPassword(user.getPassword());
        userJson.setGueszyId(user.getGueszyId());
        return userJson;
    }

    public static List<UserJson> packJsons(List<User> users){
        List<UserJson> userJsons = new ArrayList<>();
        for (User user : users){
            userJsons.add(packJson(user));
        }
        return userJsons;
    }
}
