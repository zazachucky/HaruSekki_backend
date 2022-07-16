package com.harusekki.syjmsh.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
    @Transient
    private List<CookingStepDto> CookingProcess;
    @Transient
    private List<ImageDto> imgList;
    @Transient
    private List<IngredientDto> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public List<CookingStepDto> getCookingProcess() {
        return CookingProcess;
    }

    public void setCookingProcess(List<CookingStepDto> cookingProcess) {
        CookingProcess = cookingProcess;
    }

    public List<ImageDto> getImgList() {
        return imgList;
    }

    public void setImgList(List<ImageDto> imgList) {
        this.imgList = imgList;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }
}
