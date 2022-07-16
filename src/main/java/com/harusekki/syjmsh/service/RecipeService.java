package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dto.RecipeDto;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<RecipeDto> findByTitle(String title) throws Exception;
    List<RecipeDto> findByCategory(String category) throws Exception;

    List<RecipeDto> findAllById() throws Exception;
}
