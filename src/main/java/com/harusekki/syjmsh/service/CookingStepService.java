package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dto.CookingStepDto;
import com.harusekki.syjmsh.dto.IngredientDto;

import java.util.List;

public interface CookingStepService {
    List<CookingStepDto> findByRecipeId(Long id) throws Exception;
    List<CookingStepDto> findAllById() throws Exception;
}
