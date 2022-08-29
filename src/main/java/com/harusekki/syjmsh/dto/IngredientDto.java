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
@Table(name = "ingredient")
public class IngredientDto {
    @Id
    @Column(name="ingredient_id")
    private Long id;

    @Column(name="ingredient_title")
    private String title;

    @Column(name="ingredient_category")
    private String category;

    @Column(name="ingredient_image")
    private String image;

    @Transient
    private List<Long> recipeList;
}