package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientDao  extends JpaRepository<IngredientDto, Long> {
    List<IngredientDto> findAllByOrderByIdAsc();
    List<IngredientDto> findAllByCategoryContaining(String category);
    List<IngredientDto> findAllByRecipeDtosId(Long recipe_id);
}
