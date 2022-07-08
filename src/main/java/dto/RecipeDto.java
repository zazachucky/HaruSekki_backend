package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private List<CookingStepDto> CookingProcess;
    private List<ImageDto> imgList;
    private List<IngredientDto> ingredients;
}
