package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IngredientService {

    List<IngredientDto> findAllById() throws Exception;
    List<IngredientDto> findByCategory(String category) throws Exception;

}
