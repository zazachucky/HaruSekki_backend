package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query(value = "select * from recipe\n" +
            "where recipe_id in(\n" +
            "select recipe_recipe_id\n" +
            "from recipe_has_ingredient\n" +
            "where ingredient_ingredient_id  in :ingredients\n" +
            "group by recipe_recipe_id\n" +
            "having count(recipe_recipe_id) >= :size)", nativeQuery = true)
    List<RecipeDto> findAllByIngredients(@Param("ingredients") List<Long> ingredient_ids, @Param("size") int size);
    @Query(value = "select recipe_recipe_id as recipe_id\n" +
            "from recipe_has_ingredient\n" +
            "where ingredient_ingredient_id = :ingredient_id", nativeQuery = true)
    List<Long> findAllByIngredient(@Param("ingredient_id") Long id);
}
