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
        List<IngredientDto> tempList = new ArrayList<>();
        tempList.addAll(ingredientDao.findAllByCategoryContaining(category));
        List<IngredientDto> result = new ArrayList<>();
        for(int i = 0 ; i < tempList.size(); i++){
            IngredientDto ingredientDto = new IngredientDto();
            ingredientDto.setTitle(tempList.get(i).getTitle());
            ingredientDto.setImage(tempList.get(i).getImage());
            ingredientDto.setId(tempList.get(i).getId());
            result.add(ingredientDto);
        }
        return result;
    }
    @Override
    public List<IngredientDto> findAllById() throws Exception{
        List<IngredientDto> tempList = new ArrayList<>();
        tempList.addAll(ingredientDao.findAllByOrderByIdAsc());
        List<IngredientDto> result = new ArrayList<>();
        for(int i = 0 ; i < tempList.size(); i++){
            IngredientDto ingredientDto = new IngredientDto();
            ingredientDto.setTitle(tempList.get(i).getTitle());
            ingredientDto.setImage(tempList.get(i).getImage());
            ingredientDto.setId(tempList.get(i).getId());
            result.add(ingredientDto);
        }
        return result;
    }
    @Override
    public List<IngredientDto> findByRecipeId(Long recipe_id) throws Exception{
        List<IngredientDto> tempList = new ArrayList<>();
        tempList.addAll(ingredientDao.findAllByRecipeId(recipe_id));
        List<IngredientDto> result = new ArrayList<>();
        for(int i = 0 ; i < tempList.size(); i++){
            IngredientDto ingredientDto = new IngredientDto();
            ingredientDto.setTitle(tempList.get(i).getTitle());
            ingredientDto.setImage(tempList.get(i).getImage());
            ingredientDto.setId(tempList.get(i).getId());
            ingredientDto.setCategory(tempList.get(i).getCategory());
            result.add(ingredientDto);
        }
        return result;
    }
}
