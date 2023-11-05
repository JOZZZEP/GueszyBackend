package com.example.gueszybackend.game.business;

import com.example.gueszybackend.game.json.CategoryJson;
import com.example.gueszybackend.game.model.Category;
import com.example.gueszybackend.game.payload.CategoryPayload;
import com.example.gueszybackend.game.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBusiness {
    @Autowired
    CategoryService categoryService;
    public List<CategoryJson> getListCategory(){
        return CategoryJson.packJsons(categoryService.getAllCategory());
    }

    public CategoryJson getCategoryId(long id){
        return CategoryJson.packJson(categoryService.findById(id));
    }

    public void save(CategoryPayload categoryPayload){
        Category category = new Category(categoryPayload.getName());
        categoryService.save(category);
    }
    public void update(long id, CategoryPayload categoryPayload){
        Category category = categoryService.findById(id);
        category.setName(category.getName());
        categoryService.save(category);
    }

    public void delete(long id){
        categoryService.delete(id);
    }
}
