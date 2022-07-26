package com.harusekki.syjmsh.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "recipe")
public class RecipeDto {
    @Id
    @Column(name="recipe_id")
    private Long id;

    @Column(name="recipe_title")
    private String title;

    @Column(name="recipe_category")
    private String category;

    @Column(name="recipe_summary")
    private String summary;

    @Column(name="recipe_hits")
    private Long hits;

    @Column(name="recipe_likes")
    private Long likes;

    @OneToMany(mappedBy="recipeDto")
    private List<CookingStepDto> cookingStepDtoList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ingredient",
                joinColumns = @JoinColumn(name = "recipe_id"),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<IngredientDto> ingredientDtos = new ArrayList<>();

    @Transient
    private List<ImageDto> imgList;

}