package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dto.RecipeDto;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<RecipeDto> findByTitle(String title, String order) throws Exception;
    List<RecipeDto> findByCategory(String category, String order) throws Exception;
    List<RecipeDto> findAll(String order) throws Exception;
    RecipeDto recipeDetail(Long id) throws Exception;
    List<RecipeDto> findByIngredients(List<Long> ids) throws Exception;
    List<Long> findIdListByIngredientId(Long ingredient_id) throws Exception;
}
