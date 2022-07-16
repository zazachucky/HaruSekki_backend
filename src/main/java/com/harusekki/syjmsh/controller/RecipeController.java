package com.harusekki.syjmsh.controller;

import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import com.harusekki.syjmsh.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.harusekki.syjmsh.service.RecipeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
@CrossOrigin("*")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/findbytitle")
    public ResponseEntity<?> findByTitle(@RequestParam("recipe_title") String title) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findByTitle(title));
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/findbycategory")
    public ResponseEntity<?> findByCategory(@RequestParam("recipe_category") String category) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList = recipeService.findByCategory(category);
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll() throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findAllById());
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }


    @GetMapping("/ingredient/findbycategory")
    public ResponseEntity<?> findByCategoryIngre(@RequestParam("ingredient_category") String category) throws Exception {
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        try {
            ingredientDtoList = ingredientService.findByCategory(category);
            return new ResponseEntity<List<IngredientDto>>(ingredientDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/ingredient/findall")
    public ResponseEntity<?> findAllIngre() throws Exception {
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        try {
            ingredientDtoList.addAll(ingredientService.findAllById());
            return new ResponseEntity<List<IngredientDto>>(ingredientDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e){
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
