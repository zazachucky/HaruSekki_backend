package com.harusekki.syjmsh.controller;

import com.harusekki.syjmsh.dto.CookingStepDto;
import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import com.harusekki.syjmsh.service.CookingStepService;
import com.harusekki.syjmsh.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.harusekki.syjmsh.service.RecipeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private CookingStepService cookingStepService;

    @GetMapping("/recipe/findbytitle")
    public ResponseEntity<?> findRecipeByTitle(@RequestParam("recipe_title") String title, @RequestParam("order") String order) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findByTitle(title, order));
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/recipe/findbycategory")
    public ResponseEntity<?> findRecipeByCategory(@RequestParam("recipe_category") String category, @RequestParam("order") String order) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findByCategory(category, order));
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    @GetMapping("/recipe/findbyingredients")
    public ResponseEntity<?> findRecipeByIngredients(@RequestParam("ingredients") List<Long> ids) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findByIngredients(ids));
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    @GetMapping("/recipe/findbyingredient")
    public ResponseEntity<?> findRecipeByIngredient(@RequestParam("ingredient_id") Long id) throws Exception {
        List<Long> idList = new ArrayList<>();
        try {
            idList.addAll(recipeService.findIdListByIngredientId(id));
            return new ResponseEntity<List<Long>>(idList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/recipe/findall")
    public ResponseEntity<?> findRecipeAll(@RequestParam("order") String order) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findAll(order));
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/recipe/detail")
    public ResponseEntity<?> findRecipeDetail(@RequestParam("recipe_id") Long id) throws Exception {
        RecipeDto recipeDto = new RecipeDto();
        try{
            recipeDto = recipeService.recipeDetail(id);
            return new ResponseEntity<RecipeDto>(recipeDto, HttpStatus.OK);
        }catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/ingredient/findbycategory")
    public ResponseEntity<?> findIngredientByCategory(@RequestParam("ingredient_category") String category) throws Exception {
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        try {
            ingredientDtoList.addAll(ingredientService.findByCategory(category));
            return new ResponseEntity<List<IngredientDto>>(ingredientDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/ingredient/findall")
    public ResponseEntity<?> findIngredientAll() throws Exception {
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        try {
            ingredientDtoList.addAll(ingredientService.findAll());
            return new ResponseEntity<List<IngredientDto>>(ingredientDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    @GetMapping("/ingredient/findbyrecipeid")
    public ResponseEntity<?> findIngredientByRecipeId(@RequestParam("recipe_id") Long id) throws Exception{
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        try{
            ingredientDtoList.addAll(ingredientService.findByRecipeId(id));
            return new ResponseEntity<List<IngredientDto>>(ingredientDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/cookingstep/findall")
    public ResponseEntity<?> findAllCs() throws Exception {
        List<CookingStepDto> cookingStepDtoList = new ArrayList<>();
        try {
            cookingStepDtoList.addAll(cookingStepService.findAllById());
            return new ResponseEntity<List<CookingStepDto>>(cookingStepDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/cookingstep/findbyrecipeid")
    public ResponseEntity<?> findByRecipeId(@RequestParam("recipe_id") Long id) throws Exception {
        List<CookingStepDto> cookingStepDtoList = new ArrayList<>();
        List<CookingStepDto> list = new ArrayList<>();
        try {
            cookingStepDtoList.addAll(cookingStepService.findByRecipeId(id));
            return new ResponseEntity<List<CookingStepDto>>(cookingStepDtoList, HttpStatus.OK);
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