package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dao.CookingStepDao;
import com.harusekki.syjmsh.dao.ImageDao;
import com.harusekki.syjmsh.dao.IngredientDao;
import com.harusekki.syjmsh.dao.RecipeDao;
import com.harusekki.syjmsh.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImplement implements RecipeService{
    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private CookingStepDao cookingStepDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private IngredientService ingredientService;
    @Override
    public List<RecipeDto> findByTitle(String title, String order) throws Exception{
        List<RecipeDto> tempList = new ArrayList<>();
        switch (order) {
            case "old":
                tempList.addAll(recipeDao.findAllByTitleContainingOrderByIdDesc(title)); break;
            case "latest":
                tempList.addAll(recipeDao.findAllByTitleContainingOrderByIdAsc(title)); break;
            case "hitsdesc":
                tempList.addAll(recipeDao.findAllByTitleContainingOrderByHitsDesc(title)); break;
            case "hitsasc":
                tempList.addAll(recipeDao.findAllByTitleContainingOrderByHitsAsc(title)); break;
            case "likedesc":
                tempList.addAll(recipeDao.findAllByTitleContainingOrderByLikesDesc(title)); break;
            case "likeasc":
                tempList.addAll(recipeDao.findAllByTitleContainingOrderByLikesAsc(title)); break;
        }
        for(int i = 0; i < tempList.size(); i++){
            //tempList.get(i).setCsList(cookingStepDao.findAllByRecipeid(tempList.get(i).getId()));
            tempList.get(i).setImgList(imageDao.findPathByRecipeid(tempList.get(i).getId()));
            //tempList.get(i).setIngredientList(ingredientService.findByRecipeId(tempList.get(i).getId()));
        }
        return tempList;
    }
    @Override
    public List<RecipeDto> findByCategory(String category, String order) throws Exception{
        List<RecipeDto> tempList = new ArrayList<>();
        switch (order) {
            case "old":
                tempList.addAll(recipeDao.findAllByCategoryContainingOrderByIdDesc(category)); break;
            case "latest":
                tempList.addAll(recipeDao.findAllByCategoryContainingOrderByIdAsc(category)); break;
            case "hitsdesc":
                tempList.addAll(recipeDao.findAllByCategoryContainingOrderByHitsDesc(category)); break;
            case "hitsasc":
                tempList.addAll(recipeDao.findAllByCategoryContainingOrderByHitsAsc(category)); break;
            case "likedesc":
                tempList.addAll(recipeDao.findAllByCategoryContainingOrderByLikesDesc(category)); break;
            case "likeasc":
                tempList.addAll(recipeDao.findAllByCategoryContainingOrderByLikesAsc(category)); break;
        }
        for(int i = 0; i < tempList.size(); i++){
            //tempList.get(i).setCsList(cookingStepDao.findAllByRecipeid(tempList.get(i).getId()));
            tempList.get(i).setImgList(imageDao.findPathByRecipeid(tempList.get(i).getId()));
            //tempList.get(i).setIngredientList(ingredientService.findByRecipeId(tempList.get(i).getId()));
        }
        return tempList;
    }
    @Override
    public List<RecipeDto> findAll(String order) throws Exception{
        List<RecipeDto> tempList = new ArrayList<>();
        switch (order) {
            case "old":
                tempList.addAll(recipeDao.findAllByOrderByIdDesc()); break;
            case "latest":
                tempList.addAll(recipeDao.findAllByOrderByIdAsc()); break;
            case "hitsdesc":
                tempList.addAll(recipeDao.findAllByOrderByHitsDesc()); break;
            case "hitsasc":
                tempList.addAll(recipeDao.findAllByOrderByHitsAsc()); break;
            case "likedesc":
                tempList.addAll(recipeDao.findAllByOrderByLikesDesc()); break;
            case "likeasc":
                tempList.addAll(recipeDao.findAllByOrderByLikesAsc()); break;
        }
        for(int i = 0; i < tempList.size(); i++){
           // tempList.get(i).setCsList(cookingStepDao.findAllByRecipeid(tempList.get(i).getId()));
            tempList.get(i).setImgList(imageDao.findPathByRecipeid(tempList.get(i).getId()));
           // tempList.get(i).setIngredientList(ingredientService.findByRecipeId(tempList.get(i).getId()));
        }
        return tempList;
    }
    @Override
    public List<RecipeDto> findByIngredients(List<Long> ids) throws Exception{
        List<RecipeDto> tempList = new ArrayList<>();
        tempList.addAll(recipeDao.findAllByIngredients(ids, ids.size()));
        for(int i = 0; i < tempList.size(); i++){
            //tempList.get(i).setCsList(cookingStepDao.findAllByRecipeid(tempList.get(i).getId()));
            tempList.get(i).setImgList(imageDao.findPathByRecipeid(tempList.get(i).getId()));
            //tempList.get(i).setIngredientList(ingredientService.findByRecipeId(tempList.get(i).getId()));
        }
        return tempList;
    }
    @Override
    public List<Long> findIdListByIngredientId(Long ingredient_id) throws Exception{
        List<Long> tempList = new ArrayList<>();
        tempList.addAll(recipeDao.findAllByIngredient(ingredient_id));
        return tempList;
    }
    @Override
    public RecipeDto recipeDetail(Long id) throws Exception{
        RecipeDto tempRecipe = new RecipeDto();
        tempRecipe = recipeDao.findById(id).get();
        tempRecipe.setCsList(cookingStepDao.findAllByRecipeid(id));
        tempRecipe.setImgList(imageDao.findPathByRecipeid(id));
        tempRecipe.setIngredientList(ingredientService.findByRecipeId(id));

        return tempRecipe;
    }
}
