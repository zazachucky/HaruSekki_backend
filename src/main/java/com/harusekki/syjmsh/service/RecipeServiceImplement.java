package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dao.CookingStepDao;
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
        List<RecipeDto> result = new ArrayList<>();
        for(int i = 0 ; i < tempList.size(); i++){
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setTitle(tempList.get(i).getTitle());
            recipeDto.setImgList(tempList.get(i).getImgList());
            recipeDto.setId(tempList.get(i).getId());
            result.add(recipeDto);
        }
        return result;
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
        List<RecipeDto> result = new ArrayList<>();
        for(int i = 0 ; i < tempList.size(); i++){
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setTitle(tempList.get(i).getTitle());
            recipeDto.setImgList(tempList.get(i).getImgList());
            recipeDto.setId(tempList.get(i).getId());
            result.add(recipeDto);
        }
        return result;
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
        List<RecipeDto> result = new ArrayList<>();
        for(int i = 0 ; i < tempList.size(); i++){
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setTitle(tempList.get(i).getTitle());
            recipeDto.setImgList(tempList.get(i).getImgList());
            recipeDto.setId(tempList.get(i).getId());
            result.add(recipeDto);
        }
        return result;
    }
    @Override
    public List<RecipeDto> findByIngredients(List<Long> ids) throws Exception{
        List<RecipeDto> tempList = new ArrayList<>();
        tempList.addAll(recipeDao.findAllByIngredients(ids, ids.size()));
        List<RecipeDto> result = new ArrayList<>();
        for(int i = 0 ; i < tempList.size(); i++){
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setTitle(tempList.get(i).getTitle());
            recipeDto.setImgList(tempList.get(i).getImgList());
            recipeDto.setId(tempList.get(i).getId());
            result.add(recipeDto);
        }
        return result;
    }
    @Override
    public RecipeDto recipeDetail(Long id) throws Exception{
        RecipeDto tempRecipe = new RecipeDto();
        tempRecipe = recipeDao.findById(id).get();
        tempRecipe.setCsList(cookingStepDao.findAllByRecipeid(id));

        return tempRecipe;
    }
}
