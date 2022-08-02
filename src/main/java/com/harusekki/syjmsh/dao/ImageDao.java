package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.ImageDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<ImageDto, Long> {
    List<ImageDto> findAllByRecipeid(Long recipe_id);
}
