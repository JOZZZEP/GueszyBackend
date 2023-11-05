package com.example.gueszybackend.game.controller;

import com.example.gueszybackend.exception.BaseException;
import com.example.gueszybackend.game.business.CategoryBusiness;
import com.example.gueszybackend.game.json.CategoryJson;
import com.example.gueszybackend.game.model.Category;
import com.example.gueszybackend.game.payload.CategoryPayload;
import com.example.gueszybackend.game.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gueszy")
public class CategoryController {
    @Autowired
    CategoryBusiness categoryBusiness;
    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/category/insert")
    public ResponseEntity<Void> save(@RequestBody CategoryPayload categoryPayload){
        categoryBusiness.save(categoryPayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/category/update/{id}")
    public ResponseEntity<CategoryJson> update(@PathVariable("id") long id, @RequestBody CategoryPayload categoryPayload) {
        Optional<Category> category = categoryService.findOptionalById(id);
        if (category.isPresent()) {
            categoryBusiness.update(category.get().getId(), categoryPayload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/category")
    public ResponseEntity<List<CategoryJson>> getAll() throws BaseException {
        return ResponseEntity.ok(categoryBusiness.getListCategory());
    }


    @GetMapping(value = "/category/{id}")
    public ResponseEntity<CategoryJson>
    getById(@PathVariable("id") long id) throws BaseException{
        return ResponseEntity.ok(categoryBusiness.getCategoryId(id));
    }
}
