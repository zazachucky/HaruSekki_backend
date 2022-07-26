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
@RequestMapping("/control")
@CrossOrigin("*")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private CookingStepService cookingStepService;

    @GetMapping("/recipe/findbytitle")
    public ResponseEntity<?> findByTitle(@RequestParam("recipe_title") String title) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findByTitle(title));
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/recipe/findbycategory")
    public ResponseEntity<?> findByCategory(@RequestParam("recipe_category") String category) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList.addAll(recipeService.findByCategory(category));
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/recipe/findall")
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
            ingredientDtoList.addAll(ingredientService.findByCategory(category));
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


    @GetMapping("/ingredient/findbyrecipeid")
    public ResponseEntity<?> findIngreByRecipeId(@RequestParam("recipe_id") Long id) throws Exception{
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        try{
            ingredientDtoList.addAll(ingredientService.findByRecipeId(id));
            List<String> list = new ArrayList<>();
            for(IngredientDto i : ingredientDtoList){
                list.add(i.getTitle());
            }
            return new ResponseEntity<List<String>>(list, HttpStatus.OK);
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
            System.out.println("try OK  " + cookingStepDtoList.size());

            for(CookingStepDto cs : cookingStepDtoList){
                CookingStepDto temp = new CookingStepDto();
                temp.setId(cs.getId());
                temp.setDescription(cs.getDescription());
                temp.setImage(cs.getImage());
                list.add(temp);
            }
            return new ResponseEntity<List<CookingStepDto>>(list, HttpStatus.OK);
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