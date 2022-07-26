package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dao.CookingStepDao;
import com.harusekki.syjmsh.dto.CookingStepDto;
import com.harusekki.syjmsh.dto.IngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookingStepServiceImplement implements CookingStepService{
    @Autowired
    private CookingStepDao cookingStepDao;

    @Override
    public List<CookingStepDto> findByRecipeId(Long id) throws Exception {
        List<CookingStepDto> cookingStepDtoList = new ArrayList<>();
        cookingStepDtoList.addAll(cookingStepDao.findAllByRecipeDtoId(id));

        return cookingStepDtoList;
    }
    @Override
    public List findAllById() throws Exception{
        List<CookingStepDto> cookingStepDtoList = new ArrayList<>();
        cookingStepDtoList.addAll(cookingStepDao.findAllByOrderByIdAsc());

        return cookingStepDtoList;
    }

}
