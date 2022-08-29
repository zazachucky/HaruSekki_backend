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
    @Autowired
    private RecipeDao recipeDao;

    @Override
    public List<IngredientDto> findByCategory(String category) throws Exception{
        List<IngredientDto> tempList = new ArrayList<>();
        tempList.addAll(ingredientDao.findAllByCategoryContaining(category));
        for(int i = 0; i < tempList.size(); i++){
            List<Long> idList = new ArrayList<>();
            idList.addAll(recipeDao.findAllByIngredient(tempList.get(i).getId()));
            tempList.get(i).setRecipeList(idList);
        }
        return tempList;
    }
    @Override
    public List<IngredientDto> findAll() throws Exception{
        List<IngredientDto> tempList = new ArrayList<>();
        tempList.addAll(ingredientDao.findAllByOrderByIdAsc());
        for(int i = 0; i < tempList.size(); i++){
            List<Long> idList = new ArrayList<>();
            idList.addAll(recipeDao.findAllByIngredient(tempList.get(i).getId()));
            tempList.get(i).setRecipeList(idList);
        }
        return tempList;
    }
    @Override
    public List<IngredientDto> findByRecipeId(Long recipe_id) throws Exception{
        List<IngredientDto> tempList = new ArrayList<>();
        tempList.addAll(ingredientDao.findAllByRecipeId(recipe_id));
        for(int i = 0; i < tempList.size(); i++){
            List<Long> idList = new ArrayList<>();
            idList.addAll(recipeDao.findAllByIngredient(tempList.get(i).getId()));
            tempList.get(i).setRecipeList(idList);
        }
        return tempList;
    }
}
