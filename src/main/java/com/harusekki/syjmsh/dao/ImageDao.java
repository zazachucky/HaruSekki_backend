package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.ImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageDao extends JpaRepository<ImageDto, Long> {
    List<ImageDto> findAllByRecipeid(Long recipe_id);
    @Query(value = "select image.image_path from image\n" +
            "where recipe_recipe_id = :recipe_id", nativeQuery = true)
    List<String> findPathByRecipeid(@Param("recipe_id") Long id);
}
