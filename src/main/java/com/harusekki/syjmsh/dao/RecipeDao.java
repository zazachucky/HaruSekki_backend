package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeDao extends JpaRepository<RecipeDto, Long> {
    List<RecipeDto> findAllByTitleContainingOrderByIdDesc(String title);
    List<RecipeDto> findAllByTitleContainingOrderByIdAsc(String title);
    List<RecipeDto> findAllByTitleContainingOrderByHitsDesc(String title);
    List<RecipeDto> findAllByTitleContainingOrderByHitsAsc(String title);
    List<RecipeDto> findAllByTitleContainingOrderByLikesDesc(String title);
    List<RecipeDto> findAllByTitleContainingOrderByLikesAsc(String title);
    List<RecipeDto> findAllByCategoryContainingOrderByIdDesc(String category);
    List<RecipeDto> findAllByCategoryContainingOrderByIdAsc(String category);
    List<RecipeDto> findAllByCategoryContainingOrderByHitsDesc(String category);
    List<RecipeDto> findAllByCategoryContainingOrderByHitsAsc(String category);
    List<RecipeDto> findAllByCategoryContainingOrderByLikesDesc(String category);
    List<RecipeDto> findAllByCategoryContainingOrderByLikesAsc(String category);
    List<RecipeDto> findAllByOrderByIdDesc();
    List<RecipeDto> findAllByOrderByIdAsc();
    List<RecipeDto> findAllByOrderByHitsDesc();
    List<RecipeDto> findAllByOrderByHitsAsc();
    List<RecipeDto> findAllByOrderByLikesDesc();
    List<RecipeDto> findAllByOrderByLikesAsc();
}
