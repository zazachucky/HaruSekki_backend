package com.harusekki.syjmsh.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cooking_step")
public class CookingStepDto {
    @Id
    @Column(name="cs_id")
    private Long id;

    @Column(name="cs_description")
    private String description;

    @Column(name="cs_image")
    private String image;

    @ManyToOne
    @JoinColumn(name="recipe_recipe_id", referencedColumnName = "recipe_id")
    private RecipeDto recipeDto;
}
