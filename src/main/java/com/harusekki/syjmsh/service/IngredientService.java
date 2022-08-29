package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IngredientService {
    List<IngredientDto> findAll() throws Exception;
    List<IngredientDto> findByCategory(String category) throws Exception;
    List<IngredientDto> findByRecipeId(Long recipe_id) throws Exception;

}
