package com.harusekki.syjmsh.dto;

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
@Table(name = "cooking_step")
public class CookingStepDto {
    @Id
    @Column(name="cs_id")
    private Long id;

    @Column(name="cs_description")
    private String description;

    @Column(name="cs_image")
    private String image;
}
