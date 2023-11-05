package com.example.gueszybackend.game.json;

import com.example.gueszybackend.game.model.Category;
import com.example.gueszybackend.user.json.UserJson;
import com.example.gueszybackend.user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryJson {
    private long id;
    private String name;

    public static CategoryJson packJson(Category category){
        CategoryJson categoryJson = new CategoryJson();
        categoryJson.setId(category.getId());
        categoryJson.setName(category.getName());
        return categoryJson;
    }

    public static List<CategoryJson> packJsons(List<Category> categories){
        List<CategoryJson> categoryJsons = new ArrayList<>();
        for (Category category : categories){
            categoryJsons.add(packJson(category));
        }
        return categoryJsons;
    }
}
