package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientDao  extends JpaRepository<IngredientDto, Long> {
    List<IngredientDto> findAllByOrderByIdAsc();
    List<IngredientDto> findAllByCategoryContaining(String category);
    @Query(value = "select ingredient_id, ingredient_title, ingredient_category, ingredient_image from ingredient\n" +
            "where ingredient_id in (\n" +
            "select ingredient_ingredient_id\n" +
            "from recipe_has_ingredient\n" +
            "where recipe_recipe_id = :recipe_id);", nativeQuery = true)
    List<IngredientDto> findAllByRecipeId(@Param("recipe_id") Long id);
//    List<IngredientDto> findAllByRecipeDtosId(Long recipe_id);
}
