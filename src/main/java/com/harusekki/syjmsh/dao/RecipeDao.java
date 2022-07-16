package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeDao extends JpaRepository<RecipeDto, Long> {
    List<RecipeDto> findAllByTitleContaining(String title);
    List<RecipeDto> findAllByCategoryContaining(String category);

    List<RecipeDto> findAllByOrderByIdDesc();
}
