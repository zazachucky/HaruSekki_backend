package com.harusekki.syjmsh.controller;

import com.harusekki.syjmsh.dto.RecipeDto;
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

    @GetMapping("/findbytitle")
    public ResponseEntity<?> findByTitle(@RequestParam("recipe_title") String title) throws Exception {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        try {
            recipeDtoList = recipeService.findByTitle(title);
            return new ResponseEntity<List<RecipeDto>>(recipeDtoList, HttpStatus.OK);
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
