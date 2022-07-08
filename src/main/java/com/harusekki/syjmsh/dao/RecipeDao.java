package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDao extends JpaRepository<RecipeDto, Long> {
    List<RecipeDto> findByTitle(String title);
    List<RecipeDto> findByCategory(String category);
}
