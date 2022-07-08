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
@Table(name = "image")
public class ImageDto {
    @Id
    @Column(name="image_id")
    private Long id;

    @Column(name="image_path")
    private String path;
}
