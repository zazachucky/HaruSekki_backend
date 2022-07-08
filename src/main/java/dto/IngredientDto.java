package dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private ImageDto image;

}
