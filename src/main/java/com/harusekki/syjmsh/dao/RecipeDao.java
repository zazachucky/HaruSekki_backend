package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
            "having count(recipe_recipe_id) >= :size)\n" +
            "order by recipe_id desc", nativeQuery = true)
    List<RecipeDto> findAllByIngredientsOrderByIdDesc(@Param("ingredients") List<Long> ingredient_ids, @Param("size") int size);
    @Query(value = "select * from recipe\n" +
            "where recipe_id in(\n" +
            "select recipe_recipe_id\n" +
            "from recipe_has_ingredient\n" +
            "where ingredient_ingredient_id  in :ingredients\n" +
            "group by recipe_recipe_id\n" +
            "having count(recipe_recipe_id) >= :size)\n" +
            "order by recipe_id asc", nativeQuery = true)
    List<RecipeDto> findAllByIngredientsOrderByIdAsc(@Param("ingredients") List<Long> ingredient_ids, @Param("size") int size);
    @Query(value = "select * from recipe\n" +
            "where recipe_id in(\n" +
            "select recipe_recipe_id\n" +
            "from recipe_has_ingredient\n" +
            "where ingredient_ingredient_id  in :ingredients\n" +
            "group by recipe_recipe_id\n" +
            "having count(recipe_recipe_id) >= :size)\n" +
            "order by recipe_hits desc", nativeQuery = true)
    List<RecipeDto> findAllByIngredientsOrderByHitsDesc(@Param("ingredients") List<Long> ingredient_ids, @Param("size") int size);
    @Query(value = "select * from recipe\n" +
            "where recipe_id in(\n" +
            "select recipe_recipe_id\n" +
            "from recipe_has_ingredient\n" +
            "where ingredient_ingredient_id  in :ingredients\n" +
            "group by recipe_recipe_id\n" +
            "having count(recipe_recipe_id) >= :size)\n" +
            "order by recipe_hits asc", nativeQuery = true)
    List<RecipeDto> findAllByIngredientsOrderByHitsAsc(@Param("ingredients") List<Long> ingredient_ids, @Param("size") int size);
    @Query(value = "select * from recipe\n" +
            "where recipe_id in(\n" +
            "select recipe_recipe_id\n" +
            "from recipe_has_ingredient\n" +
            "where ingredient_ingredient_id  in :ingredients\n" +
            "group by recipe_recipe_id\n" +
            "having count(recipe_recipe_id) >= :size)\n" +
            "order by recipe_likes desc", nativeQuery = true)
    List<RecipeDto> findAllByIngredientsOrderByLikesDesc(@Param("ingredients") List<Long> ingredient_ids, @Param("size") int size);
    @Query(value = "select * from recipe\n" +
            "where recipe_id in(\n" +
            "select recipe_recipe_id\n" +
            "from recipe_has_ingredient\n" +
            "where ingredient_ingredient_id  in :ingredients\n" +
            "group by recipe_recipe_id\n" +
            "having count(recipe_recipe_id) >= :size)\n" +
            "order by recipe_likes asc", nativeQuery = true)
    List<RecipeDto> findAllByIngredientsOrderByLikesAsc(@Param("ingredients") List<Long> ingredient_ids, @Param("size") int size);
//    @Query(value = "select recipe_recipe_id as recipe_id\n" +
//            "from recipe_has_ingredient\n" +
//            "where ingredient_ingredient_id = :ingredient_id", nativeQuery = true)
//    List<Long> findAllByIngredient(@Param("ingredient_id") Long id);
    @Query(value = "update recipe\n" +
            "set recipe_hits = recipe_hits + 1\n" +
            "where recipe_id = :recipe_id", nativeQuery = true)
    @Modifying
    void hitByRecipeId(@Param("recipe_id") Long id);
    @Query(value = "update recipe\n" +
            "set recipe_likes = recipe_likes + 1\n" +
            "where recipe_id = :recipe_id", nativeQuery = true)
    @Modifying
    void LikeByRecipeId(@Param("recipe_id") Long id);
}
