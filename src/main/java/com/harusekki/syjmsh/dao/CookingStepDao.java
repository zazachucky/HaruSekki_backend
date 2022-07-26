package com.harusekki.syjmsh.dao;

import com.harusekki.syjmsh.dto.CookingStepDto;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CookingStepDao extends JpaRepository<CookingStepDto, Long> {
    List<CookingStepDto> findAllByRecipeDtoId(Long recipe_id);
    List<CookingStepDto> findAllByOrderByIdAsc();

}
