package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dao.IngredientDao;
import com.harusekki.syjmsh.dao.RecipeDao;
import com.harusekki.syjmsh.dto.IngredientDto;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImplement implements IngredientService{
    @Autowired
    private IngredientDao ingredientDao;

    @Override
    public List<IngredientDto> findByCategory(String category) throws Exception{
        List<IngredientDto> ingredientDtoList = new ArrayList<>();

        ingredientDtoList.addAll(ingredientDao.findAllByCategoryContaining(category));

        return ingredientDtoList;
    }

    public List<IngredientDto> findAllById() throws Exception{
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        ingredientDtoList.addAll(ingredientDao.findAllByOrderByIdAsc());

        return ingredientDtoList;
    }

}
